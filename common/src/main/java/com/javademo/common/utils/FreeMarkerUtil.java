package com.javademo.common.utils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;


public class FreeMarkerUtil {
    private FreeMarkerUtil() {
    }

    private static final Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);

    static {
        cfg.setDefaultEncoding("UTF-8");
        cfg.setClassForTemplateLoading(FreeMarkerUtil.class, "classpath:template/");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
    }

    public static Template getTemplate(String templateName) throws IOException {
        return cfg.getTemplate(templateName);
    }
    //todo singleton classpath loader cfg and  string loader cfg
    //每次启动时初始化 string loader cfg
    //使用 xml解析出每一个dsl元素 method作为键 缓存到 stringLoader中
    public static String generateFromString(String source,Object param) throws TemplateException, IOException {
//        StringTemplateLoader stringLoader = new StringTemplateLoader();
//        stringLoader.putTemplate("greetTemplate", "<#macro greet>Hello</#macro>");
//        stringLoader.putTemplate("myTemplate", "<#include \"greetTemplate\"><@greet/> World!");
        return "";
    }
    public static String generateHtml(String templateName, Object param) throws IOException, TemplateException {
        Template template = cfg.getTemplate(templateName);
        StringWriter writer = new StringWriter();
        template.process(param, writer);
        return writer.toString();
    }
}
