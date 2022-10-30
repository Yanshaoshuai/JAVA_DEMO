package com.freemapper.core;

import com.freemapper.core.parser.BaseParser;
import com.freemapper.core.parser.CommonSearchParser;
import com.freemapper.core.parser.SearchByIdParser;
import com.freemapper.core.util.ReflectUtil;
import com.freemapper.core.util.ResourceUtil;
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

    /**
     * 获取已存在的FreeMapper单例对象
     * @return
     */
    public static FreeMapper getInstance(){
        if(instance==null){
            throw new RuntimeException("instance not init,pls call getInstance(String xmlPath, RestClient restClient, String mapperPath) before");
        }
        return instance;
    }

    /**
     * 初始化FreeMapper单例对象
     * @param xmlPath
     * @param restClient
     * @param mapperPath
     * @return
     * @throws IOException
     */
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

    /**
     * 获取代理Mapper实例Map集合
     * @return
     */
    public Map<String, Object> getMapperInstanceMap() {
        return mapperInstanceMap;
    }

    /**
     * 获取特定代理Mapper实例
     * @param clazz
     * @return
     * @param <T>
     */
    public <T> T getMapperInstance(Class<T> clazz){
        return (T) mapperInstanceMap.get(clazz.getSimpleName());
    }

    /**
     * 获取ElasticSearch RestClient
     * @return
     */
    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    /**
     * 获取解析器实例map集合
     * @return
     */
    public Map<String, BaseParser> getParserMap() {
        return parserMap;
    }

}
