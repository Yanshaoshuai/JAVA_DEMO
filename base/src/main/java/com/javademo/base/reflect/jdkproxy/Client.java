package com.javademo.base.reflect.jdkproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
    /*    ProxyInvocationHandler pih=new ProxyInvocationHandler();
        pih.setHost(new Host());
        Rent proxy = pih.getProxy();
        proxy.rent();*/
      //通用类
      CommonProxyInvocationHandler commonPIH=new CommonProxyInvocationHandler();
      commonPIH.setRealObject(new Host());
      Object proxy = commonPIH.getProxy();
      ((Rent)proxy).rent();

      //用匿名类实现
       Object realObject= new Host();
       InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName()+"执行前");
                Object result = method.invoke(realObject, args);
                System.out.println(method.getName()+"执行后");
                return result;
            }
        };
        Object proxyInstance = Proxy.newProxyInstance(Client.class.getClassLoader(), realObject.getClass().getInterfaces(), invocationHandler);
        ((Rent)proxyInstance).rent();
    }
}
