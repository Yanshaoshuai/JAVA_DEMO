package com.javademo.es.mapper;

import com.javademo.es.pojo.Student;

import java.io.IOException;

public interface TestMapper {
    Student getStudentById(String id) throws IOException;
    Student getStudentByAge(int age);
}
