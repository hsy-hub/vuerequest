package com.vue.data.demo.vuerequest.service;

import com.vue.data.demo.vuerequest.mapper.ProductMapper;
import com.vue.data.demo.vuerequest.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
/**
 * @author hsy
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public Product getProductById(Integer id) {
        return productMapper.getProductById(id);
    }

    @Override
    public List<Product> getProductList(HashMap map) {
        return productMapper.getProductList(map);
    }

    @Override
    public Integer selectProCount(String productName) {
        return productMapper.selectProCount(productName);
    }
}
