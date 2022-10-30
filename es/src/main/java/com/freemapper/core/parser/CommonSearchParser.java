package com.freemapper.core.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freemapper.core.XmlMethod;
import com.freemapper.core.entity.search.Hit;
import com.freemapper.core.entity.search.SearchResult;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class CommonSearchParser implements BaseParser{
    @Override
    public <T> T parse(Method method, XmlMethod xmlMethod, String json) throws ClassNotFoundException, JsonProcessingException {
        if(List.class.isAssignableFrom(method.getReturnType())){
            ObjectMapper mapper = new ObjectMapper();
            String resultType = xmlMethod.getResultType();
            Class<?> innerType = Class.forName(resultType);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(SearchResult.class,innerType);
            SearchResult<?> searchResult = mapper.readValue(json, javaType);
            List<? extends Hit<?>> hits = searchResult.getHits().getHits();
            List result=new LinkedList();
            for (Hit<?> hit:hits){
                result.add(hit.getSource());
            }
            return (T) result;
        }else if (SearchResult.class.isAssignableFrom(method.getReturnType())){
            //返回SearchResult
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructType(method.getGenericReturnType());
            return (T)mapper.readValue(json, javaType);
        }
        throw new RuntimeException(String.format("parser can't parse this result:\n%s",json));
    }
}
