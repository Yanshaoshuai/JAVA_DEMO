package com.javademo.es;

import com.javademo.common.utils.FreeMarkerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties
public class EsApp {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(EsApp.class, args);
    }
}
