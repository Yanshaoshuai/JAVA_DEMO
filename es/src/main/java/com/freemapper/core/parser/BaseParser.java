package com.freemapper.core.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.freemapper.core.XmlMethod;

import java.lang.reflect.Method;

public interface BaseParser {
    <T> T parse(Method method, XmlMethod xmlMethod, String json) throws ClassNotFoundException, JsonProcessingException;
}
