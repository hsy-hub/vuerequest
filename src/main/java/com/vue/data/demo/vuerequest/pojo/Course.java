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
     * book
     */
    private String book;
    /**
     * introduce
     */
    private String introduce;
    /**
     * m_id
     */
    private Integer m_id;

    /**
     * image
     */
    private String image;

    /**
     * major
     */
    private Major major;
}
