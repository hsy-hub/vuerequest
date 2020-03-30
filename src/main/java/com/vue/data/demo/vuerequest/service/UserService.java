package com.vue.data.demo.vuerequest.service;

import com.vue.data.demo.vuerequest.pojo.User;

import java.util.List;

public interface UserService {
    public Integer addUser(User user);
    public Integer delUserById(Integer id);
    public List<User> getUserList(User user);
}
