package com.javademo.base.reflect.proxy;

public class Proxy implements Rent {
    private Rent host;
    @Override
    public void rent() {
        System.out.println("先发布租房信息");
        host.rent();
        System.out.println("出租完房子提供后续管理");
    }

    public void setHost(Rent host) {
        this.host = host;
    }
}
