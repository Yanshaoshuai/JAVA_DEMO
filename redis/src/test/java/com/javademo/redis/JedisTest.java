package com.javademo.redis;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class JedisTest {
    @Autowired
    private Jedis jedis;

    private final static Logger LOG = LoggerFactory.getLogger(JedisTest.class);

    @Test
    public void testString(){
        jedis.set("a","1");
        String av = jedis.get("a");
        LOG.info(av);
        Long isSet = jedis.setnx("a", "2");
        if(isSet==0){
            LOG.info("a has exist");
        }
        LOG.info("a ttl is {}",jedis.ttl("a"));
        jedis.setex("a",10l,"3");
        LOG.info("a ttl is {}",jedis.ttl("a"));
    }
    @Test
    public void testHash(){
        jedis.hset("xiaoming", Map.of("age","12"));
        String age = jedis.hget("xiaoming","age");
        LOG.info(age);
        Long hsetnx = jedis.hsetnx("xiaoming", "age", "13");
        if(hsetnx==0){
            LOG.info("xiaoming.age has exist");
        }
        jedis.expire("xiaoming",3l);
        Long ttl = jedis.ttl("xiaoming");
        LOG.info("xiaoming ttl is {}",ttl);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        age = jedis.hget("xiaoming", "age");
        LOG.info(age);
        //todo 多字段操作
    }
}
