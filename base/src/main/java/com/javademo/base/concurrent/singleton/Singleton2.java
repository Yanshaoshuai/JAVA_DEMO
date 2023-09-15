package com.javademo.base.concurrent.singleton;

/**
 * 饿汉式 可用
 * @Author YSS
 * @Date 2020/6/14 18:35
 */
public class Singleton2 {
    private final static Singleton2 INSTANCE;
    static {
        INSTANCE=new Singleton2();
    }
    private Singleton2(){

    }
    private static Singleton2 getInstance(){
        return INSTANCE;
    }
}
