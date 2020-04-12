package com.vue.data.demo.vuerequest.service;

import com.vue.data.demo.vuerequest.mapper.UserMapper;
import com.vue.data.demo.vuerequest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer delUserById(Integer id) {
        return userMapper.delUserById(id);
    }

    @Override
    public List<User> getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public List<User> getUserList(HashMap map) {
        return userMapper.getUserList(map);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Integer deleteUser(List<Integer> id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public Integer selectUserCount(String name) {
        return userMapper.selectUserCount(name);
    }

//    @Override
//    public List<User> getUserList(User user) {
//        return userMapper.getUserList(user);
//    }

}
