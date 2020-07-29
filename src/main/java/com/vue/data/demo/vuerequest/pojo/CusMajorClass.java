package com.vue.data.demo.vuerequest.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生  封装 major class_
 * @author hsy
 */
@Data
@NoArgsConstructor
public class CusMajorClass extends Customer{
    private Major major;
    private Class_ class_;
}
