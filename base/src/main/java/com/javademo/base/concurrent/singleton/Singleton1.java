package com.javademo.base.concurrent.singleton;

/**
 * 饿汉式 可用
 * @Author YSS
 * @Date 2020/6/14 18:33
 */
public class Singleton1 {
    private final static Singleton1 INSTANCE=new Singleton1();
    private Singleton1(){

    }
    private static Singleton1 getInstance(){
        return INSTANCE;
    }
}
