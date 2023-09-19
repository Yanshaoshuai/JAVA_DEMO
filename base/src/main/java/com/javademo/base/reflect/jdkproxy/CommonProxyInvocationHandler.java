package com.javademo.base.reflect.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//通用代理类
//这个类动态生成代理类,并用invoke方法调用原来方法，可以在其中添加代理逻辑
public class CommonProxyInvocationHandler implements InvocationHandler {
    private Object realObject;

    public void setRealObject(Object realObject) {
        this.realObject = realObject;
    }

    //动态生成代理类
    public Object getProxy(){
        Object proxyInstance = Proxy.newProxyInstance(this.getClass().getClassLoader(), realObject.getClass().getInterfaces(), this);
        return proxyInstance;
    }
    //处理代理实例并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"方法执行前");
        Object result = method.invoke(realObject, args);
        System.out.println(method.getName()+"方法执行后");
        return result;
    }
}
