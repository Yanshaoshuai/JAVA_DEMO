package com.javademo.base.reflect.proxy;

public class Client{
    public static void main(String[] args) {
        Host host=new Host();
        Proxy proxy=new Proxy();
        proxy.setHost(host);
        proxy.rent();
    }
}
