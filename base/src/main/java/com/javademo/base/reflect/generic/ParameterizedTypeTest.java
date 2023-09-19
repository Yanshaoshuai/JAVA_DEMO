package com.javademo.base.reflect.generic;

import com.google.gson.Gson;
import org.apache.commons.lang3.reflect.TypeUtils;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParameterizedTypeTest {

    static void  test(){
        ParameterizedType parameterizedType = TypeUtils.parameterize(List.class, String.class);
        Gson gson=new Gson();
        List<String> strings = gson.fromJson("""
                ["111","222","333"]
                """, parameterizedType);
        System.out.println(parameterizedType.getTypeName());
        System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        System.out.println(parameterizedType.getOwnerType());
        System.out.println(parameterizedType.getRawType());
        System.out.println(parameterizedType.getClass());
        System.out.println(strings);
    }

    List<String> method(){
        return new ArrayList<>();
    }
    static void getInstanceFromType() throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        Method method = ParameterizedTypeTest.class.getDeclaredMethod("method");
        ParameterizedType returnType = (ParameterizedType)method.getGenericReturnType();
        Class clazz = (Class)returnType.getActualTypeArguments()[0];
        Object o = clazz.newInstance();
        System.out.println(o);
    }

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        test();
        getInstanceFromType();
    }
}
