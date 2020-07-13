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
    private String headPath;
}
