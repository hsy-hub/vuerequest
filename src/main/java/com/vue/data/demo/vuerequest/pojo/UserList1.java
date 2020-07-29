package com.vue.data.demo.vuerequest.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员和老师  封装classroom
 * @author hsy
 */
@Data
@NoArgsConstructor
public class UserList1 extends User {
    private ClassRoom classRoom;
    private Rank rank;
}
