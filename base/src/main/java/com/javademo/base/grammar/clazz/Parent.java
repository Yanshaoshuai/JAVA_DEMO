package com.javademo.base.grammar.clazz;

public class Parent {
    //step3
    private int a=1;
    //step1
    private static int b=1;

    /**
     * step4
     */
    public Parent() {
        init();
    }

    protected void init(){
        System.out.println("parent init");
    }
}
