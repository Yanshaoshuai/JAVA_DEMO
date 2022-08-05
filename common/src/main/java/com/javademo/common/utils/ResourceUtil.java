package com.javademo.common.utils;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ResourceUtil {
    private final ResourceLoader resourceLoader;

    public ResourceUtil(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public  InputStream resourceLoader(String fileFullPath) throws IOException {
        return resourceLoader.getResource(fileFullPath).getInputStream();
    }
}
