package com.vue.data.demo.vuerequest.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author hsy
 */
@Data
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer password;
    private Integer age;
    private String gender;
    /**
     * 专业外键
     */
    private Integer m_id;
    /**
     * 班级外键
     */
    private Integer cl_id;
    /**
     * 级别外键
     */
    private Integer r_id;
    /**
     * 课程外键
     */
    private Integer co_id;
    /**
     * 课程外键
     */
    private Integer g_id;
}
