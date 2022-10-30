package com.javademo.es;

import com.freemapper.core.entity.search.SearchResult;
import com.javademo.es.pojo.Product;
import com.javademo.es.service.ProductService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {
    private final static Logger LOG = LoggerFactory.getLogger(ProductServiceTest.class);

    private final ProductService productService;

    @Autowired
    public ProductServiceTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void getListTest() {
        try {
            List<Product> list = productService.getList();
            LOG.info("product list:{} ", list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void searchTest() {
        try {
            SearchResult<Product> search = productService.search();
            LOG.info("product list:{} ", search);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
