package com.javademo.base.grammar.clazz;

public class Child extends Parent{
    //step 6
    private int a=1;
    //step 2
    private static int b=1;

    /**
     * step7
     */
    public Child() {
        System.out.println("child constructor");
    }

    /**
     * step5
     */
    @Override
    protected void init() {
        System.out.println("child init");
    }

    public static void main(String[] args) {
        new Child();
    }
}
