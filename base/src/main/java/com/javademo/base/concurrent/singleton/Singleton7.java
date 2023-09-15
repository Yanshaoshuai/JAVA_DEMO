package com.javademo.base.concurrent.singleton;

/**
 * 懒汉式
 * @Author YSS
 * @Date 2020/6/14 18:39
 */
public class Singleton7 {
    private static class SingletonInstance{
        private final static Singleton7 INSTANCE=new Singleton7();
    }
    private Singleton7(){

    }
    private static Singleton7 getInstance(){
        //第一次使用才加载
        return SingletonInstance.INSTANCE;
    }
}
