package com.javademo.freemapper.core;

import com.javademo.freemapper.core.parser.BaseParser;
import com.javademo.freemapper.core.parser.CommonSearchParser;
import com.javademo.freemapper.core.parser.SearchByIdParser;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JdkInvocation implements InvocationHandler {
    private final Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
    private Object target;
    private XmlReader xmlReader;
    private RestClient restClient;
    private Map<String, BaseParser> parserMap;

    JdkInvocation() {
        super();
    }

    public JdkInvocation(XmlReader xmlReader, RestClient restClient) {
        super();
        this.xmlReader = xmlReader;
        this.restClient = restClient;
        parserMap=new HashMap<>();
        parserMap.put("CommonSearchParser",new CommonSearchParser());
        parserMap.put("SearchByIdParser",new SearchByIdParser());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws TemplateException, IOException, ClassNotFoundException {
        Map<String, List<XmlMethod>> xmlMethods = xmlReader.getXmlMethods();
        List<XmlMethod> methodList = xmlMethods.get(method.getDeclaringClass().getName());
        for (XmlMethod xmlMethod : methodList) {
            if ((method.getDeclaringClass().getName() + "#" + method.getName()).equals(xmlMethod.getId())) {
                return execute(xmlMethod, buildParam(method, args), method);
            }
        }
        return null;
    }

    private static Map<String, Object> buildParam(Method method, Object[] args) {
        Parameter[] parameters = method.getParameters();
        HashMap<String, Object> params = new HashMap<>();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            params.put(parameter.getName(), args[i]);
        }
        return params;
    }

    private Object execute(XmlMethod xmlMethod, Map<String, Object> params, Method method) throws TemplateException, IOException, ClassNotFoundException {
        switch (xmlMethod.getType().toUpperCase()) {
            case "GET" -> {
                return execGet(xmlMethod, params, method);
            }
            case "POST" -> {
                return execPost(xmlMethod, params, method);
            }
            default -> {
                return null;
            }
        }
    }

    private Object execPost(XmlMethod xmlMethod, Map<String, Object> params, Method method) {
        return null;
    }

    public String getResultDsl(String methodId, Object param) throws IOException, TemplateException {
        Configuration fmCfg = xmlReader.getCfg();
        Template template = fmCfg.getTemplate(methodId);
        StringWriter writer = new StringWriter();
        template.process(param, writer);
        String resultDsl = writer.toString();
        writer.close();
        return resultDsl;
    }
//todo ResultParser -- Upsert Delete  Aggregation Page
    private Object execGet(XmlMethod xmlMethod, Map<String, Object> params, Method method) throws IOException, TemplateException, ClassNotFoundException {
        Request request;
        if(StringUtils.isNotEmpty(xmlMethod.getUrl())){
            request = new Request("GET", "/" + xmlMethod.getIndex() + xmlMethod.getUrl());
        }else {
            request = new Request("GET", "/" + xmlMethod.getIndex() + getResultDsl(xmlMethod.getParamUrlId(),params));
        }
        request.setJsonEntity(getResultDsl(xmlMethod.getId(), params));
        Response response = restClient.performRequest(request);
        HttpEntity entity = response.getEntity();
        String entityStr = EntityUtils.toString(entity);
        BaseParser parser = parserMap.get(xmlMethod.getResultParser());
        return parser.parse(method,xmlMethod,entityStr);
    }
}

