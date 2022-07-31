package com.javademo.api.controller;

import com.javademo.common.api.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final static Logger LOG = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.ok("hello");
    }

    @GetMapping("/entity/hello")
    public ResponseEntity<Map<String, Object>> responseEntityHello() {
        return ResponseEntity.ok(Map.of("name", "yan", "age", 20));
    }
}
