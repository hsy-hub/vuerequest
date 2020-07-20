package com.vue.data.demo.vuerequest.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hsy
 */
@Data
@NoArgsConstructor
public class Course {
    /**
     * id
     */
    private Integer id;
    /**
     * courseName
     */
    private String courseName;
    /**
     * m_id
     */
    private Integer m_id;
    /**
     * major
     */
    private Major major;
}
