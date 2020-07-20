package com.vue.data.demo.vuerequest.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hsy
 */
@Data
@NoArgsConstructor
public class UserList extends User{
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
