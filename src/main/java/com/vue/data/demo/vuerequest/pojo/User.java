package com.vue.data.demo.vuerequest.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员和老师
 * @author hsy
 */
@Data
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String age;
    private String password;
    private String gender;
    private Integer cr_id;
    private Integer r_id;
    private String token;
}
