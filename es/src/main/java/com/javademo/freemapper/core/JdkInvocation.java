package com.javademo.freemapper.core;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.javademo.common.utils.FreeMarkerUtil;
import com.javademo.es.pojo.Student;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;


public class JdkInvocation implements InvocationHandler {
    private Object target;
    private List<XmlMethod> xmlMethods;

    JdkInvocation() {
        super();
    }

    JdkInvocation(Object target, List<XmlMethod> xmlMethods) {
        super();
        this.target = target;
        this.xmlMethods = xmlMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        for (XmlMethod xmlMethod : xmlMethods) {
            if (method.getName().equals(xmlMethod.getId())) {
                return execute(xmlMethod, args);
            }
        }
        return null;
    }

    private Object execute(XmlMethod xmlMethod, Object[] args) {
        switch (xmlMethod.getType().toUpperCase()) {
            case "GET" -> {
                return execGet(xmlMethod, args);
            }
            case "POST" -> {
                return execPost(xmlMethod, args);
            }
            default -> {
                return null;
            }
        }
    }

    private Object execPost(XmlMethod xmlMethod, Object[] args) {
        return null;
    }

    private Object execGet(XmlMethod xmlMethod, Object[] args) {
        String content = xmlMethod.getContent();
        //todo generate dsl from content and args
        //use rest client to call es
        return null;
    }
}
