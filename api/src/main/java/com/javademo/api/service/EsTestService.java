package com.javademo.api.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.javademo.api.pojo.Student;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EsTestService {
    private final RestClient restClient;

    public EsTestService(RestClient restClient) {
        this.restClient = restClient;
    }

    public Student getById(String id) throws IOException {
        Request request = new Request("GET",String.format("/student/_doc/%s",id));
        Response response = restClient.performRequest(request);
        HttpEntity entity = response.getEntity();
        String entityStr = EntityUtils.toString(entity);
        Gson gson=new Gson();
        JsonObject jsonObject = gson.fromJson(entityStr, JsonObject.class);
        Student student=new Student();
        if(jsonObject.has("_source")){
            JsonElement source = jsonObject.get("_source");
            student=gson.fromJson(source,Student.class);
        }
        return student;
    }
}
