package com.javademo.base.concurrent.singleton;

/**
 * 懒汉式 线程不安全 不推荐
 * @Author YSS
 * @Date 2020/6/14 18:39
 */
public class Singleton5 {
    private static Singleton5 instance;
    private Singleton5(){

    }
    private static  Singleton5 getInstance(){
        if(instance==null){
            //进入判断就会创建实例
            synchronized(Singleton5.class){
                instance=new Singleton5();
            }
        }
        return instance;
    }
}
