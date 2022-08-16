package com.javademo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javademo.pojo.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class ReflectTest {
    public class A {
        public List<User> getList(){
            return new LinkedList<>();
        }
        public List getListNoGeneric(){
            return new LinkedList<>();
        }
    }
    @Test
    public void testGenericMethod(){
        Class<A> aClass = A.class;
        try {
            Method method = aClass.getMethod("getList");
            Class<?> returnType = method.getReturnType();
            Type genericReturnType = method.getGenericReturnType();
            System.out.println(returnType);
            System.out.println(genericReturnType);
            System.out.println(genericReturnType instanceof ParameterizedType);


            String json="[{\"id\":\"1\",\"name\":\"yan\",\"createdTime\":\"2022-08-16 15:16:45\",\"updatedTime\":\"2022-08-16 15:16:45\"}]";
            ObjectMapper objectMapper=new ObjectMapper();
            objectMapper.findAndRegisterModules();
            JavaType javaType = objectMapper.getTypeFactory().constructType(genericReturnType);
            System.out.println(javaType.getRawClass());
            List<User> users=objectMapper.readValue(json, javaType);
            System.out.println(users);
        } catch (NoSuchMethodException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testMethod(){
        Class<A> aClass = A.class;
        try {
            Method method = aClass.getMethod("getListNoGeneric");
            Class<?> returnType = method.getReturnType();
            Type genericReturnType = method.getGenericReturnType();
            System.out.println(returnType);
            System.out.println(genericReturnType);

            System.out.println(genericReturnType instanceof ParameterizedType);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
