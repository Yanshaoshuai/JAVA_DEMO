package com.javademo.base.concurrent.threadlocal;

/**
 * 线程内全局变量
 * @Author YSS
 * @Date 2020/6/22 17:17
 */
public class ThreadLocalInternal {
    private static ThreadLocal <User> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) {
        User user=new User("yan");
        threadLocal.set(user);
        new Service1().process();
    }
    static class User{
        public User(String name) {
            this.name = name;
        }
        private String name;
    }
    static class Service1{
        public void process(){
            User user=threadLocal.get();
            System.out.println(Thread.currentThread().getId()+":Service1#process---username--->"+user.name);
            new Service2().process();
        }
    }
    static class Service2{
        public void process(){
            User user=threadLocal.get();
            System.out.println(Thread.currentThread().getId()+":Service2#process---username--->"+user.name);
            new Service3().process();
        }
    }
    static class Service3{
        public void process(){
            User user=threadLocal.get();
            System.out.println(Thread.currentThread().getId()+":Service3#process---username--->"+user.name);
        }
    }

}
