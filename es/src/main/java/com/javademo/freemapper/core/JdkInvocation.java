package com.javademo.freemapper.core;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


public class JdkInvocation implements InvocationHandler {
    private final Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
    private Object target;
    private XmlReader xmlReader;
    private RestClient restClient;

    JdkInvocation() {
        super();
    }

    public JdkInvocation(XmlReader xmlReader, RestClient restClient) {
        super();
        this.xmlReader = xmlReader;
        this.restClient=restClient;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws TemplateException, IOException {
        Map<String, List<XmlMethod>> xmlMethods = xmlReader.getXmlMethods();
        List<XmlMethod> methodList = xmlMethods.get(method.getDeclaringClass().getName());
        for (XmlMethod xmlMethod : methodList) {
            if ((method.getDeclaringClass().getName()+"#"+method.getName()).equals(xmlMethod.getId())) {
                return execute(xmlMethod, args, method.getReturnType());
            }
        }
        return null;
    }

    private Object execute(XmlMethod xmlMethod, Object[] args, Class<?> resultType) throws TemplateException, IOException {
        switch (xmlMethod.getType().toUpperCase()) {
            case "GET" -> {
                return execGet(xmlMethod, args, resultType);
            }
            case "POST" -> {
                return execPost(xmlMethod, args, resultType);
            }
            default -> {
                return null;
            }
        }
    }

    private Object execPost(XmlMethod xmlMethod, Object[] args, Class<?> resultType) {
        return null;
    }

    public String getResultDsl(String methodId,Object param) throws IOException, TemplateException {
        Configuration fmCfg = xmlReader.getCfg();
        Template template = fmCfg.getTemplate(methodId);
        StringWriter writer = new StringWriter();
        template.process(param, writer);
        String resultDsl = writer.toString();
        writer.close();
        return resultDsl;
    }
    private Object execGet(XmlMethod xmlMethod, Object[] args, Class<?> resultType) throws IOException, TemplateException {
        Request request = new Request("GET", "/"+xmlMethod.getIndex()+xmlMethod.getUrl());
        request.setJsonEntity(getResultDsl(xmlMethod.getId(),args[0]));
        Response response = restClient.performRequest(request);
        HttpEntity entity = response.getEntity();
        String entityStr = EntityUtils.toString(entity);
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(entityStr, JsonObject.class);
        JsonArray innerHits = jsonObject.get("hits").getAsJsonObject().get("hits").getAsJsonArray();
        for (int i=0;i<innerHits.size();i++){
            JsonObject sourceOuter = innerHits.get(i).getAsJsonObject();
            if (sourceOuter.has("_source")) {
                JsonElement source = sourceOuter.get("_source");
                return gson.fromJson(source, resultType);
            }
        }
        return null;
    }
}
