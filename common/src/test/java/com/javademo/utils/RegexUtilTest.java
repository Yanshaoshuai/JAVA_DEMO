package com.javademo.utils;

import com.javademo.common.utils.RegexUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegexUtilTest {
    private final static Logger LOG = LoggerFactory.getLogger(RegexUtilTest.class);

    @Test
    public void  testRegex(){
        LOG.info("checkEmail(\"13@123.com\") {}",RegexUtil.checkEmail("13@123.com"));
        LOG.info("checkEmail(\"ahutyss@gmail.com\") {}",RegexUtil.checkEmail("ahutyss@gmail.com"));
        LOG.info("checkEmail(\"1446999156@qq.com\") {}",RegexUtil.checkEmail("1446999156@qq.com"));
        LOG.info("checkName(\"@qdsas\") {}",RegexUtil.checkName("@qdsas"));
        LOG.info("checkName(\"qdsas_闫\") {}",RegexUtil.checkName("qdsas_闫"));
        LOG.info("checkPsw(\"qdsas_闫\") {}",RegexUtil.checkPsw("qdsas_闫"));
        LOG.info("checkPsw(\"123yedf_\") {}",RegexUtil.checkPsw("123yedf_"));
        LOG.info("regexCheck(\"yan shaoshuai\",\"^(yan)(\\\\s)?(shaoshuai)+\",0) {}",RegexUtil.regexCheck("yan shaoshuai","^(yan)(\\s)?(shaoshuai)+",0));
        LOG.info("regexCheck(\"yanshaoshuai\",\"^(yan)(\\\\s)?(shaoshuai)+\",0) {}",RegexUtil.regexCheck("yanshaoshuai","^(yan)(\\s)?(shaoshuai)+",0));
        LOG.info("regexCheck(\"yanshaoshuai\",\"^(yan)(\\\\s)?(shaoshuai)+\",0) {}",RegexUtil.regexCheck("yanshaoshua","^(yan)(\\s)?(shaoshuai)+",0));
        LOG.info("regexCheck(\"there are yanshaoshuai\",\".*yan(\\\\s)?(shaoshuai)+\",0) {}",RegexUtil.regexCheck("there are yanshaoshuai",".*yan(\\s)?(shaoshuai)+",0));
        LOG.info("regexCheck(\"there are yanshaoshuai\",\"[\\\\s\\\\S]*yan[\\\\s\\\\S]*shaoshuai\",0) {}",RegexUtil.regexCheck("there are yanshaoshuai","[\\s\\S]*yan[\\s\\S]*shaoshuai",0));
    }
}
