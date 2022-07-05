package com.javademo.api.controller;

import com.javademo.common.api.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/hello")
    public Result<String> hello(){
        return Result.ok("hello");
    }
}
