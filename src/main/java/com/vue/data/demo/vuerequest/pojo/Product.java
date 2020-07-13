package com.vue.data.demo.vuerequest.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author hsy
 */
@Data
@NoArgsConstructor
public class Product {
    private Integer id;
    private String productName;
    private Integer productPrice;
    private Integer productTotal;
    private String productDetail;
    private String imagePath;
}
