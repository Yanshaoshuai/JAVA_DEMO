package com.javademo.base.reflect.proxy;

public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("我是房东,我要出租房子");
    }
}
