package com.javademo.api;

import com.javademo.common.utils.ExecScriptUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.IOException;

@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties
public class App {
    public static void main(String[] args) throws IOException {
        ExecScriptUtil.execWindows("dir");
        SpringApplication.run(App.class,args);
    }
}
