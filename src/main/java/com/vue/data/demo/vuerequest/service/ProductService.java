package com.vue.data.demo.vuerequest.service;

import com.vue.data.demo.vuerequest.pojo.Product;
import java.util.HashMap;
import java.util.List;
/**
 * @author hsy
 */
public interface ProductService {
    /**
     * getProductById
     * @param id
     * @return id
     */
    public Product getProductById(Integer id);

    /**
     * getProductList
     * @param map
     * @return map
     */
    public List<Product> getProductList(HashMap map);

    /**
     * selectProCount
     * @param productName
     * @return productName
     */
   public Integer selectProCount(String productName);
}
