package com.javademo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/illegal/exception")
    public void illegalArgumentException(){
        throw new IllegalArgumentException("argument illegal");
    }
    @GetMapping("/exception")
    public void exception(){
        throw new NullPointerException("argument illegal");
    }

}
