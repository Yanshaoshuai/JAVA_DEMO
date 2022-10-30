package com.freemapper.core.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freemapper.core.XmlMethod;
import com.freemapper.core.entity.byid.SearchByIdResult;

import java.lang.reflect.Method;

public class SearchByIdParser implements BaseParser{
    @Override
    public <T> T parse(Method method, XmlMethod xmlMethod, String json) throws JsonProcessingException {
        if (SearchByIdResult.class.isAssignableFrom(method.getReturnType())){
            //返回 SearchByIdResult
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructType(method.getGenericReturnType());
            return (T) mapper.readValue(json, javaType);
        }else{
            //返回pojo
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(SearchByIdResult.class,method.getReturnType());
            SearchByIdResult<?> searchByIdResult = mapper.readValue(json, javaType);
            return (T) searchByIdResult.getSource();
        }
    }
}
