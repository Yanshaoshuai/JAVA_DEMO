package com.javademo.es.mapper;

import com.javademo.es.pojo.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface TestMapper {
    List<Student> getByName(String name) throws IOException;
    Student getById(String id) throws IOException;
    Student getStudentByAge(int age);
}
