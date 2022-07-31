package com.javademo.utils;

import com.javademo.common.utils.FreeMarkerUtil;
import com.javademo.common.utils.JacksonUtil;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FreemarkerTest {
    private static final Logger LOG = LoggerFactory.getLogger(JacksonUtil.class);

    public static class Person {
        private String name;
        private Integer age;
        private List<Person> children;
        private Map<String, String> properties;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public List<Person> getChildren() {
            return children;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        public Map<String, String> getProperties() {
            return properties;
        }

        public void setProperties(Map<String, String> properties) {
            this.properties = properties;
        }
    }

    @Test
    public void testFreemarker() {
        Person person = new Person();
        person.setAge(28);
        person.setName("yan");
        person.setProperties(Map.of("school", "student", "office", "worker", "home", "husband"));
        Person child1 = new Person();
        child1.setAge(3);
        child1.setName("xiaobai");
        child1.setProperties(Map.of("home", "child"));
        Person child2 = new Person();
        child2.setAge(4);
        child2.setName("xiaohong");
        child2.setProperties(Map.of("home", "child"));
        person.setChildren(List.of(child1, child2));
        try {
            String html = FreeMarkerUtil.generateHtml("free-marker-test.ftl", person);
            LOG.info(html);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
