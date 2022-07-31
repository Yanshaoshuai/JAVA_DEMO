package com.javademo.es;

import com.google.gson.Gson;
import com.javademo.es.pojo.Student;
import com.javademo.es.service.EsService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class EsServiceTest {
    private final static Logger LOG = LoggerFactory.getLogger(EsServiceTest.class);

    private final EsService esService;

    @Autowired
    public EsServiceTest(EsService esService){
        this.esService=esService;
    }

    @Test
    public void testGetById(){
        try {
            Student student = esService.getById("1");
            assert student!=null;
            Gson gson=new Gson();
            LOG.info(gson.toJson(student));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
