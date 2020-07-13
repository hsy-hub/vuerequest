package com.vue.data.demo.vuerequest.mapper;

import com.vue.data.demo.vuerequest.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
/**
 * @author hsy
 */
@Mapper
@Repository
public interface ProductMapper {
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
     * @author hsy
     */
    public Integer selectProCount(String productName);
}
