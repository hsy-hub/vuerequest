package com.vue.data.demo.vuerequest.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * customer 的列表（学生）
 * @author hsy
 */
@Data
@NoArgsConstructor
public class UserList extends Customer {
    /**
     * major
     */
    private Major major;
    /**
     * class_
     */
    private Class_ class_;
    /**
     * rank
     */
    private Rank rank;
    /**
     * course
     */
    private Course course;
    /**
     * grade
     */
    private Grade grade;

}
