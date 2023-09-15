package com.javademo.base.concurrent.singleton;

/**
 * 懒汉式 线程不安全
 * @Author YSS
 * @Date 2020/6/14 18:36
 */
public class Singleton3 {
    private static Singleton3 instance;
    private Singleton3(){

    }
    private static Singleton3 getInstance(){
        if(instance==null){
            //多线程环境下多个线程竞争可能创建多个实例
            instance=new Singleton3();
        }
        return instance;
    }
}
