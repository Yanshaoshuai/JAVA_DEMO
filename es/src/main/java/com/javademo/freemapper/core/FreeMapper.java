package com.javademo.freemapper.core;

import com.javademo.common.utils.ReflectUtil;
import com.javademo.common.utils.ResourceUtil;
import com.javademo.freemapper.core.parser.BaseParser;
import com.javademo.freemapper.core.parser.CommonSearchParser;
import com.javademo.freemapper.core.parser.SearchByIdParser;
import org.apache.commons.io.IOUtils;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FreeMapper {
    private XmlReader xmlReader;
    private RestClient restClient;
    private Map<String, BaseParser> parserMap;
    private Map<String, Object> mapperInstanceMap;
    private static volatile FreeMapper instance;

    private FreeMapper() {
    }
    public static FreeMapper getInstance(String xmlPath, RestClient restClient, String mapperPath) throws IOException {
        if (instance == null) {
            synchronized (FreeMapper.class) {
                if (instance == null) {
                    instance = new FreeMapper();
                    List<String> resourceFiles = ResourceUtil.getResourceFiles(xmlPath);
                    List<String> xmlFiles = new LinkedList<>();
                    for (String filename : resourceFiles) {
                        String xmlFile = IOUtils.resourceToString(xmlPath + filename, StandardCharsets.UTF_8);
                        xmlFiles.add(xmlFile);
                    }
                    instance.xmlReader = new XmlReader();
                    instance.xmlReader.init(xmlFiles);
                    instance.restClient = restClient;
                    instance.parserMap = new HashMap<>();
                    instance.parserMap.put("CommonSearchParser", new CommonSearchParser());
                    instance.parserMap.put("SearchByIdParser", new SearchByIdParser());
                    Set<Class<?>> classSet = ReflectUtil.findAllClassesUsingClassLoader(mapperPath);
                    instance.mapperInstanceMap = new HashMap<>();
                    for (Class<?> clazz : classSet) {
                        instance.mapperInstanceMap.put(clazz.getSimpleName(), clazz.cast(Proxy.newProxyInstance(FreeMapper.class.getClassLoader(), new Class[]{clazz}, new JdkInvocation(instance.xmlReader, restClient, instance.parserMap))));
                    }
                }
            }
        }
        return instance;
    }

    public Map<String, Object> getMapperInstanceMap() {
        return mapperInstanceMap;
    }

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public Map<String, BaseParser> getParserMap() {
        return parserMap;
    }

}
