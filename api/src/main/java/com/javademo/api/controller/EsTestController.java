package com.javademo.api.controller;

import com.javademo.api.pojo.Student;
import com.javademo.api.service.EsTestService;
import com.javademo.common.api.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/es/test")
public class EsTestController {
    private final EsTestService esTestService;
    public EsTestController(EsTestService esTestService) {
        this.esTestService = esTestService;
    }

    @GetMapping("{id}")
    public Result<Student> getById(@PathVariable String id) throws IOException {
        return Result.ok(esTestService.getById(id));
    }
}
