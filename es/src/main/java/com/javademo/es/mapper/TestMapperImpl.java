package com.javademo.es.mapper;

import com.javademo.common.utils.FreeMarkerUtil;
import com.javademo.es.pojo.Student;
import freemarker.template.Template;

import java.io.IOException;
import java.util.Map;

public class TestMapperImpl implements TestMapper{
    @Override
    public Student getStudentById(String id) throws IOException {
        return null;
    }

    @Override
    public Student getStudentByAge(int age) {
        return null;
    }
}
