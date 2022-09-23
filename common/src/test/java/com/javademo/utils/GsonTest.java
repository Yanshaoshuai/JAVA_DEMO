package com.javademo.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javademo.common.utils.GsonUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GsonTest {
    private final static Logger LOG = LoggerFactory.getLogger(GsonTest.class);

    @Test
    public void testCommonError(){
        Map<String, String> stringStringMap = Map.of("11", "22");
        //有多余的双引号
        LOG.info("{}",GsonUtil.beanToJsonObj(stringStringMap).get("11"));
    }

    /**
     * 泛型反序列化
     */
    @Test
    public void testGeneric(){
        Gson gson=new Gson();
        String jsonString="{\"11\":\"22\"}";
        Type type=new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> map = gson.fromJson(jsonString, type);
        System.out.println(map);
    }
}
