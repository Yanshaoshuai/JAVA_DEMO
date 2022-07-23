package com.javademo.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties
public class RedisApp {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(RedisApp.class,args);
    }
}
