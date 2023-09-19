package com.javademo.base.reflect.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//这个类动态生成代理类,并用invoke方法调用原来方法，可以在其中添加代理逻辑
public class ProxyInvocationHandler implements InvocationHandler {
    private Rent rent;

    public void setHost(Rent rent) {
        this.rent = rent;
    }

    //动态生成代理类
    public Rent getProxy(){
        Rent proxyInstance = (Rent) Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
        return proxyInstance;
    }
    //处理代理实例并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前");
        Object result = method.invoke(rent, args);
        System.out.println("方法执行后");
        return result;
    }
}
