package com.javademo.utils;

import com.javademo.pojo.Goods;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class Dom4jTest {
    @Test
    public void dom4jTest() {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(Dom4jTest.class.getResourceAsStream("/xml/test.xml"));
            Element rootElement = document.getRootElement();
            String classAttribute = rootElement.attributeValue("class");
            Class<?> clazz = Class.forName(classAttribute);
            Constructor<?> constructor = clazz.getConstructor();
            List<Element> elements = rootElement.elements();
            List<Goods> models=new LinkedList<>();
            for (Element element : elements) {
                String id = element.attributeValue("id");
                String name = element.attributeValue("name");
                String price = element.attributeValue("price");
                String content = element.getTextTrim();
                Goods model = (Goods)constructor.newInstance();
                model.setId(id);
                model.setName(name);
                model.setPrice(Integer.valueOf(price));
                model.setContent(content);
                models.add(model);
            }
            System.out.println(models);
        } catch (DocumentException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                 InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
