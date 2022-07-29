package com.javademo.common.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;


public class FreeMarkerUtil {
    private FreeMarkerUtil(){}
    private static final Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);

    static {
        cfg.setDefaultEncoding("UTF-8");
        try {
            File dir = ResourceUtils.getFile("classpath:template/");
            cfg.setDirectoryForTemplateLoading(dir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
    }

    public static String generateHtml(String templateName, Object param) throws IOException, TemplateException {
        Template template = cfg.getTemplate(templateName);
        StringWriter writer=new StringWriter();
        template.process(param,writer);
        return writer.toString();
    }
}
