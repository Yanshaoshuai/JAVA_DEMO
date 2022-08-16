package com.javademo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javademo.pojo.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class JacksonTest {
    @Test
    public void testPojoToJson(){
        User user = new User();
        user.setId("1");
        user.setName("yan");
        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedTime(LocalDateTime.now());
        ObjectMapper objectMapper=new ObjectMapper();
        //注册jackson-datatype-jsr310 模块 以识别 Java 8 date/time type
        objectMapper.findAndRegisterModules();
        try {
            String json = objectMapper.writeValueAsString(user);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testJsonToPojo(){
        String json="{\"id\":\"1\",\"name\":\"yan\",\"createdTime\":\"2022-08-16 15:16:45\",\"updatedTime\":\"2022-08-16 15:16:45\"}";
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try {
            User user = objectMapper.readValue(json, User.class);
            System.out.println(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testJsonToPojoWithGeneric(){
        String json="[{\"id\":\"1\",\"name\":\"yan\",\"createdTime\":\"2022-08-16 15:16:45\",\"updatedTime\":\"2022-08-16 15:16:45\"}]";
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try {
            List<User> users = objectMapper.readValue(json, new TypeReference<>() {});
            System.out.println(users);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testJsonToPojoWithGenericUseJavaType(){
        String json="[{\"id\":\"1\",\"name\":\"yan\",\"createdTime\":\"2022-08-16 15:16:45\",\"updatedTime\":\"2022-08-16 15:16:45\"}]";
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.findAndRegisterModules();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, User.class);
        try {
//            List<JavaType> users = objectMapper.readValue(json, javaType);
            List<User> users = objectMapper.readValue(json, javaType);
            System.out.println(users);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
