package com.javademo.es.service;

import com.freemapper.core.FreeMapper;
import com.freemapper.core.entity.search.SearchResult;
import com.javademo.es.mapper.ProductMapper;
import com.javademo.es.pojo.Product;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    private final RestClient restClient;

    public ProductService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Product> getList() throws IOException {
        FreeMapper instance = FreeMapper.getInstance("/template/", restClient, "com.javademo.es.mapper");
        ProductMapper mapperInstance = instance.getMapperInstance(ProductMapper.class);
        return mapperInstance.getList(10);
    }

    public SearchResult<Product> search() throws IOException {
        FreeMapper instance = FreeMapper.getInstance("/template/", restClient, "com.javademo.es.mapper");
        ProductMapper mapperInstance = instance.getMapperInstance(ProductMapper.class);
        return mapperInstance.search(10);
    }

}
