package com.javademo.es.mapper;

import com.javademo.es.pojo.Student;

import java.io.IOException;
import java.util.Map;

public interface TestMapper {
    Student getByName(Map<String,Object> param) throws IOException;
    Student getStudentByAge(int age);
}
