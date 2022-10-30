package com.freemapper.core;

import com.freemapper.core.parser.BaseParser;
import com.freemapper.core.util.IdUtil;
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

/**
 * 动态代理类
 * 提供根据接口和xml文件信息生成动态代理类的功能
 */
public class JdkInvocation implements InvocationHandler {
    private XmlReader xmlReader;
    private RestClient restClient;
    private Map<String, BaseParser> parserMap;

    /**
     * 动态代理类初始化方法
     * @param xmlReader
     * @param restClient
     * @param parserMap
     */
    public JdkInvocation(XmlReader xmlReader, RestClient restClient,Map<String, BaseParser> parserMap) {
        super();
        this.xmlReader = xmlReader;
        this.restClient = restClient;
        this.parserMap=parserMap;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws TemplateException, IOException, ClassNotFoundException {
        Map<String, List<XmlMethod>> xmlMethods = xmlReader.getXmlMethods();
        List<XmlMethod> methodList = xmlMethods.get(method.getDeclaringClass().getName());
        for (XmlMethod xmlMethod : methodList) {
            if ((IdUtil.generateMethodId(method.getDeclaringClass().getName(),method.getName())).equals(xmlMethod.getId())) {
                return execute(xmlMethod, buildParam(method, args), method);
            }
        }
        return null;
    }

    /**
     * 构建模板参数
     * @param method
     * @param args
     * @return
     */
    private static Map<String, Object> buildParam(Method method, Object[] args) {
        Parameter[] parameters = method.getParameters();
        HashMap<String, Object> params = new HashMap<>();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            params.put(parameter.getName(), args[i]);
        }
        return params;
    }

    /**
     * 获取渲染后的dsl
     * @param methodId
     * @param param
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public String getResultDsl(String methodId, Object param) throws IOException, TemplateException {
        Configuration fmCfg = xmlReader.getCfg();
        Template template = fmCfg.getTemplate(methodId);
        StringWriter writer = new StringWriter();
        template.process(param, writer);
        String resultDsl = writer.toString();
        writer.close();
        return resultDsl;
    }

    /**
     * 使用模板和参数调用ElasticSearch RestClient,并解析返回结果
     * @param xmlMethod
     * @param params
     * @param method
     * @return
     * @throws IOException
     * @throws TemplateException
     * @throws ClassNotFoundException
     * todo ResultParser -- Upsert Delete  Aggregation Page
     */
    private Object execute(XmlMethod xmlMethod, Map<String, Object> params, Method method) throws IOException, TemplateException, ClassNotFoundException {
        Request request;
        if (StringUtils.isNotEmpty(xmlMethod.getUrl())) {
            request = new Request(xmlMethod.getType(), "/" + xmlMethod.getIndex() + xmlMethod.getUrl());
        } else {
            request = new Request(xmlMethod.getType(), "/" + xmlMethod.getIndex() + getResultDsl(xmlMethod.getParamUrlId(), params));
        }
        request.setJsonEntity(getResultDsl(xmlMethod.getId(), params));
        Response response = restClient.performRequest(request);
        HttpEntity entity = response.getEntity();
        String entityStr = EntityUtils.toString(entity);
        BaseParser parser = parserMap.get(xmlMethod.getResultParser());
        return parser.parse(method, xmlMethod, entityStr);
    }
}

