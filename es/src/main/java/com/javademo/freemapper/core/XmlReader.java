package com.javademo.freemapper.core;

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
    public Map<Class<?>, List<XmlMethod>> readMethods(List<InputStream> xmlInputs) {
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
}
