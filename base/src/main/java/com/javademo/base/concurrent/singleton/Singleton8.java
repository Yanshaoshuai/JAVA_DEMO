package com.javademo.base.concurrent.singleton;

/**
 * 枚举 生产中最好的方法
 * 1.写法简单
 * 2.线程安全有保障
 * 3.避免反序列化破坏单例
 * @Author YSS
 * @Date 2020/6/14 18:39
 */
public enum  Singleton8 {
        INSTANCE;
        public void whatever(){
            System.out.println("whatever...");
        }
}
