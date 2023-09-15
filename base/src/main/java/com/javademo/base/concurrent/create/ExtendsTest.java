package com.javademo.base.concurrent.create;

/**
 * @Author YSS
 * @Date 2020/6/11 23:26
 */
public class    ExtendsTest {
    public static class Parent {
        public void run() {
            System.out.println("Parent#run");
        }

        public void start() {
            this.run();
        }
    }
    static class  Child  extends Parent{
        @Override
        public void run() {
            System.out.println("Child#run");
        }
    }

    public static void main(String[] args) {
        Parent parent=new Child();
        parent.start();
    }
}
