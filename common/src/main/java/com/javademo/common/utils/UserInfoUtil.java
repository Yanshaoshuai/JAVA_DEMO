package com.javademo.common.utils;

import com.javademo.common.pojo.BaseUser;

public class UserInfoUtil {
    private static final ThreadLocal<BaseUser> userThreadLocal=new ThreadLocal<>();
    public static void addCurrentUser(BaseUser user){
        userThreadLocal.set(user);
    }
    public static BaseUser getCurrentUser(){
        return userThreadLocal.get();
    }
}
