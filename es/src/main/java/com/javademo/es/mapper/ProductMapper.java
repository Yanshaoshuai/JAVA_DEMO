package com.javademo.es.mapper;

import com.freemapper.core.entity.search.SearchResult;
import com.javademo.es.pojo.Product;

import java.io.IOException;
import java.util.List;

public interface ProductMapper {
    List<Product> getList(Integer size) throws IOException;
    SearchResult<Product> search(Integer size) throws IOException;
}
