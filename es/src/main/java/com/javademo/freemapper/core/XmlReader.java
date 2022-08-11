package com.javademo.freemapper.core;

import com.javademo.common.utils.FreeMarkerUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class XmlReader {
    private  final Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
    private Map<Class<?>, List<XmlMethod>> xmlMethods;

    public Map<Class<?>, List<XmlMethod>> getXmlMethods() {
        return xmlMethods;
    }


    private Map<Class<?>, List<XmlMethod>> readMethods(List<InputStream> xmlInputs) {
        Map<Class<?>, List<XmlMethod>> result = new HashMap<>();
        SAXReader saxReader = new SAXReader();
        for (InputStream xmlInput : xmlInputs) {
            List<XmlMethod> models = new LinkedList<>();
            try (xmlInput) {
                Document document = saxReader.read(xmlInput);
                Element rootElement = document.getRootElement();
                String classAttribute = rootElement.attributeValue("class");
                Class<?> clazz = Class.forName(classAttribute);
                List<Element> elements = rootElement.elements();
                for (Element element : elements) {
                    String id = element.attributeValue("method");
                    String type = element.attributeValue("type");
                    String content = element.getTextTrim();
                    XmlMethod model = new XmlMethod();
                    model.setId(id);
                    model.setContent(content);
                    model.setType(type);
                    models.add(model);
                }
                result.put(clazz, models);
            } catch (DocumentException | ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
    public  Configuration init(List<InputStream> xmlInputs) {
        xmlMethods=readMethods(xmlInputs);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setClassForTemplateLoading(FreeMarkerUtil.class, "classpath:template/");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        for (Map.Entry<Class<?>,List<XmlMethod>> entry:xmlMethods.entrySet()){
            Class<?> clazz = entry.getKey();
            List<XmlMethod> methods = entry.getValue();
            for (int i = 0; i < i; i++) {
                stringLoader.putTemplate(clazz.getName()+"#"+methods.get(i).getId(),methods.get(i).getContent());
            }
        }
        return cfg;
    }
}
