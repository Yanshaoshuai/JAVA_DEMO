package com.javademo.freemapper.util;

public class IdUtil {
    public static String generateMethodId(String prefix, String methodName){
        return prefix+"#"+methodName;
    }
    public static String generateParamUrlId(String prefix, String methodName,String suffix){
        return prefix+"#"+methodName+suffix;
    }
}
