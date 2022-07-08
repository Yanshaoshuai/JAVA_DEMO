package com.javademo.api.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileService {

    private final String uploadPath;

    public FileService(@Value("${file.upload-dir}") String uploadPath) {
        this.uploadPath = uploadPath;
        Path path = Path.of(uploadPath);
        if(!Files.exists(path)){
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String storeFile(MultipartFile file) throws IOException {

        try {
            File distFile = new File(uploadPath + file.getOriginalFilename());
            InputStream inputStream = file.getInputStream();
            IOUtils.copy(inputStream,new FileOutputStream(distFile));
            return file.getOriginalFilename();
        } catch (IOException ex) {
            throw ex;
        }
    }

    public Resource loadFileAsResource(String fileName) throws FileNotFoundException, MalformedURLException {
        Resource resource = new FileUrlResource(uploadPath + fileName);
        if (resource.exists()) {
            return resource;
        } else {
            throw new FileNotFoundException("File not found " + fileName);
        }
    }
}
