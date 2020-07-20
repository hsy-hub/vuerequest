package com.vue.data.demo.vuerequest.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hsy
 */
@Data
@NoArgsConstructor
public class ClassRoom {
    /**
     * id
     */
    private Integer id;
    /**
     * classnum 教室号
     */
    private Integer classnum;
    /**
     * yn 是否借出 1是 0否
     */
    private String yn;
}
