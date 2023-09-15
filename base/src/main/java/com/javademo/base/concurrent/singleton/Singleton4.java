package com.javademo.base.concurrent.singleton;

/**
 * 懒汉式 线程安全 不推荐 效率太低
 * @Author YSS
 * @Date 2020/6/14 18:39
 */
public class Singleton4 {
    private static Singleton4 instance;
    private Singleton4(){

    }
    private static synchronized Singleton4 getInstance(){
        if(instance==null){
            instance=new Singleton4();
        }
        return instance;
    }
}
