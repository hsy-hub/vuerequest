package com.vue.data.demo.vuerequest.service;

import com.vue.data.demo.vuerequest.mapper.UserMapper;
import com.vue.data.demo.vuerequest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer delUserById(Integer id) {
        return userMapper.delUserById(id);
    }

    @Override
    public List<User> getUserList(User user) {
        return userMapper.getUserList(user);
    }

}
