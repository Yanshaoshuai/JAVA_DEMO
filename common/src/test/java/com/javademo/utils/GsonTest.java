package com.javademo.utils;

import com.javademo.common.utils.GsonUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class GsonTest {
    private final static Logger LOG = LoggerFactory.getLogger(GsonTest.class);

    @Test
    public void testCommonError(){
        Map<String, String> stringStringMap = Map.of("11", "22");
        //有多余的双引号
        LOG.info("{}",GsonUtil.beanToJsonObj(stringStringMap).get("11"));
    }
}
