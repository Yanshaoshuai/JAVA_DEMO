package com.javademo.api.controller;

import com.javademo.api.interceptor.LogInterceptor;
import com.javademo.common.api.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final static Logger LOG = LoggerFactory.getLogger(LogInterceptor.class);
    @GetMapping("/hello")
    public Result<String> hello(){
        return Result.ok("hello");
    }
}
