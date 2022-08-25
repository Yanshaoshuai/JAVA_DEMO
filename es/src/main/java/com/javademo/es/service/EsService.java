package com.javademo.es.service;

import com.freemapper.core.FreeMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.javademo.es.mapper.TestMapper;
import com.javademo.es.pojo.Student;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EsService {
    private final RestClient restClient;

    public EsService(RestClient restClient) {
        this.restClient = restClient;
    }

    public Student getById(String id) throws IOException {
        Request request = new Request("GET", String.format("/student/_doc/%s", id));
        Response response = restClient.performRequest(request);
        HttpEntity entity = response.getEntity();
        String entityStr = EntityUtils.toString(entity);
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(entityStr, JsonObject.class);
        Student student = new Student();
        if (jsonObject.has("_source")) {
            JsonElement source = jsonObject.get("_source");
            student = gson.fromJson(source, Student.class);
        }
        return student;
    }

    public Student getByIdWithFM(String id) throws IOException {
        FreeMapper instance = FreeMapper.getInstance("/template/", restClient, "com.javademo.es.mapper");
//        TestMapper testMapper = (TestMapper) instance.getMapperInstanceMap().get("TestMapper");
        TestMapper testMapper = instance.getMapperInstance(TestMapper.class);
        return testMapper.getById(id);
    }

    public List<Student> getByNameWithFM(String name) throws IOException {
        FreeMapper instance = FreeMapper.getInstance("/template/", restClient, "com.javademo.es.mapper");
//        TestMapper testMapper = (TestMapper) instance.getMapperInstanceMap().get("TestMapper");
        TestMapper testMapper = instance.getMapperInstance(TestMapper.class);
        return testMapper.getByName(name);
    }
}
