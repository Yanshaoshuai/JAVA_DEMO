package com.javademo.base.concurrent.singleton;

/**
 * 懒汉式 线程安全 推荐面试使用
 * @Author YSS
 * @Date 2020/6/14 18:39
 */
public class Singleton6 {
    private static volatile Singleton6 instance;
    private Singleton6(){

    }
    private static Singleton6 getInstance(){
        if(instance==null){
            //在此竞争
            synchronized(Singleton6.class){
                //再做判断
                if(instance==null){
                    //new对象分成三个指令volatile防止重排序(防止获取到半初始化对象)
                    /**
                     * new #2<T> 创建一个空对象
                     * dup
                     * invokespecial #3 <T.<init>> 调用构造方法 赋值
                     * astore_1 把变量和对象关联
                     * return
                     */
                    instance=new Singleton6();
                }
            }
        }
        return instance;
    }
}
