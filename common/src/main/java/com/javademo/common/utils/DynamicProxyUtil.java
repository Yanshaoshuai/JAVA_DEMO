package com.javademo.common.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyUtil {
    static class JdkInvocation implements InvocationHandler{
        private Object target;
        JdkInvocation() {
            super();
        }
        JdkInvocation(Object target){
            super();
            this.target=target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }
}
