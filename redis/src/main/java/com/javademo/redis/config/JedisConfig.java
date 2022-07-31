package com.javademo.redis.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class JedisConfig {
    @Bean
    public Jedis getJedis(JedisConfigEntity configEntity) {
        Jedis jedis = new Jedis(configEntity.getHost(), configEntity.getPort());
        if (StringUtils.isNotEmpty(configEntity.getPassword())) {
            jedis.auth(configEntity.getPassword());
        }
        return jedis;
    }
}
