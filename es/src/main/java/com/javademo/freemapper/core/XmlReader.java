package com.javademo.freemapper.core;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang3.StringUtils;
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
    private   Configuration cfg;
    private Map<String, List<XmlMethod>> xmlMethods;

    public Map<String, List<XmlMethod>> getXmlMethods() {
        return xmlMethods;
    }

    public Configuration getCfg() {
        return cfg;
    }

    private Map<String, List<XmlMethod>> readMethods(List<InputStream> xmlInputs) {
        Map<String, List<XmlMethod>> result = new HashMap<>();
        SAXReader saxReader = new SAXReader();
        for (InputStream xmlInput : xmlInputs) {
            List<XmlMethod> models = new LinkedList<>();
            try (xmlInput) {
                Document document = saxReader.read(xmlInput);
                Element rootElement = document.getRootElement();
                String classAttribute = rootElement.attributeValue("class");
                String globalIndex = rootElement.attributeValue("index");
                Class<?> clazz = Class.forName(classAttribute);
                String clazzName = clazz.getName();
                List<Element> elements = rootElement.elements();
                for (Element element : elements) {
                    String id = element.attributeValue("method");
                    String type = element.attributeValue("type");
                    String index = element.attributeValue("index");
                    String url = element.attributeValue("url");
                    String content = element.getTextTrim();
                    XmlMethod model = new XmlMethod();
                    model.setId(clazzName+"#"+id);
                    model.setContent(content);
                    model.setType(type);
                    if(StringUtils.isEmpty(index)){
                        model.setIndex(globalIndex);
                    }else {
                        model.setIndex(index);
                    }
                    model.setUrl(url);
                    models.add(model);
                }
                result.put(clazz.getName(), models);
            } catch (DocumentException | ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
    public  void init(List<InputStream> xmlInputs) {
        cfg= new Configuration(Configuration.VERSION_2_3_31);
        xmlMethods=readMethods(xmlInputs);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        for (Map.Entry<String,List<XmlMethod>> entry:xmlMethods.entrySet()){
            List<XmlMethod> methods = entry.getValue();
            for (XmlMethod xmlMethod:methods) {
                stringLoader.putTemplate(xmlMethod.getId(),xmlMethod.getContent());
            }
        }
        cfg.setTemplateLoader(stringLoader);
    }
}

