package com.javademo.redis;

import com.javademo.redis.config.JedisConfigEntity;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class JedisTest {

    @Autowired
    private JedisConfigEntity configEntity;
    private final static Logger LOG = LoggerFactory.getLogger(JedisTest.class);

    public static Jedis getNewJedisClient(JedisConfigEntity configEntity) {
        Jedis jedis = new Jedis(configEntity.getHost(), configEntity.getPort());
        if (StringUtils.isNotEmpty(configEntity.getPassword())) {
            jedis.auth(configEntity.getPassword());
        }
        return jedis;
    }

    @Test
    public void testString() {
        Jedis jedis = getNewJedisClient(configEntity);
        jedis.set("a", "1");
        String av = jedis.get("a");
        LOG.info(av);
        Long isSet = jedis.setnx("a", "2");
        if (isSet == 0) {
            LOG.info("a has exist");
        }
        LOG.info("a ttl is {}", jedis.ttl("a"));
        jedis.setex("a", 10l, "3");
        LOG.info("a ttl is {}", jedis.ttl("a"));
        jedis.incr("a");
        LOG.info(jedis.get("a"));
        jedis.del("a");
    }

    @Test
    public void testList() {
        Jedis jedis = getNewJedisClient(configEntity);

        jedis.lpush("listA", "5", "4", "3", "2", "1");
        List<String> listALR = jedis.lrange("listA", 0, 4);
        LOG.info(listALR.toString());
        for (int i = 0; i < 5; i++) {
            System.out.println(jedis.lpop("listA"));
        }
        jedis.lpush("listA", "5", "4", "3", "2", "1");
        for (int i = 0; i < 5; i++) {
            System.out.println(jedis.rpop("listA"));
        }
        jedis.del("listA");
    }

    @Test
    public void testHash() {
        Jedis jedis = getNewJedisClient(configEntity);

        jedis.del("xiaoming");
        jedis.hset("xiaoming", Map.of("age", "12"));
        String age = jedis.hget("xiaoming", "age");
        LOG.info(age);
        Long hsetnx = jedis.hsetnx("xiaoming", "age", "13");
        if (hsetnx == 0) {
            LOG.info("xiaoming.age has exist");
        }
        jedis.expire("xiaoming", 3l);
        Long ttl = jedis.ttl("xiaoming");
        LOG.info("xiaoming ttl is {}", ttl);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        age = jedis.hget("xiaoming", "age");
        LOG.info(age);
        // 多字段操作
        jedis.hmset("user1", Map.of("name", "shaoshuai", "age", "20"));
        List<String> hmget = jedis.hmget("user1", "name", "age");
        LOG.info(hmget.toString());
        jedis.del("xiaoming");
        jedis.del("user1");
    }

    @Test
    public void testSet() {
        Jedis jedis = getNewJedisClient(configEntity);

        jedis.sadd("even", "2", "4", "6", "8", "10", "10");
        Set<String> even = jedis.smembers("even");
        LOG.info("even {}", even);
        for (int i = 0; i < 10; i++) {
            String randEven = jedis.srandmember("even");
            LOG.info("randEven {}", randEven);
        }
        Long ttl = jedis.ttl("even");
        LOG.info("ttl {}", ttl);
        jedis.expire("even", 3l);
        ttl = jedis.ttl("even");
        LOG.info("ttl {}", ttl);
        //会覆盖,无视类型
//        jedis.set("even","100");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOG.info("even {}", jedis.smembers("even"));
        jedis.del("even");
        jedis.sadd("setA", "1", "2", "3");
        jedis.sadd("setB", "2", "3", "4");
        //差集
        Set<String> sdiff = jedis.sdiff("setA", "setB");
        LOG.info(sdiff.toString());
        //交集
        Set<String> sinter = jedis.sinter("setA", "setB");
        LOG.info(sinter.toString());
        //并集
        Set<String> sunion = jedis.sunion("setA", "setB");
        LOG.info(sunion.toString());
        jedis.del("setA", "setB");
    }

    @Test
    public void testZset() {
        Jedis jedis = getNewJedisClient(configEntity);

        jedis.zadd("student_score", Map.of("xiaoming", 99.0, "xiaohong", 88.0, "xiaobai", 77.5));
        Set<String> student_score = jedis.zrange("student_score", 0, 1);
        LOG.info(student_score.toString());
        Set<Tuple> studentTuples = jedis.zrangeWithScores("student_score", 0, 1);
        LOG.info(studentTuples.toString());
        student_score = jedis.zrange("student_score", 0, -1);
        LOG.info(student_score.toString());
        student_score = jedis.zrange("student_score", -1, -1);
        LOG.info(student_score.toString());
        student_score = jedis.zrangeByScore("student_score", 70.0, 90.0);
        LOG.info(student_score.toString());
        jedis.del("student_score");
    }

    @Test
    public void pubAndSub() {

        new Thread(() -> {
            Jedis jedis = getNewJedisClient(configEntity);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 10; i++) {
                jedis.publish("mychannel", "count=" + i);
            }
        }).start();
        Jedis jedis = getNewJedisClient(configEntity);

        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onSubscribe(String channel, int subscribedChannels) {
                LOG.info("channel {} , subscribedChannels {} onSubscribe", channel, subscribedChannels);
            }

            @Override
            public void onMessage(String channel, String message) {
                LOG.info("channel {},message {}", channel, message);
            }
        }, "mychannel");
    }
}
