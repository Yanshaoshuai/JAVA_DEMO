package com.javademo.job;

import com.javademo.common.utils.ExecScriptUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JobApp {
    public static void main(String[] args) throws IOException {
        ExecScriptUtil.execWindows("dir");
        SpringApplication.run(JobApp.class,args);
    }
}
