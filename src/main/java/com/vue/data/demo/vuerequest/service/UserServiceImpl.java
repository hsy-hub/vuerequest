package com.vue.data.demo.vuerequest.service;

import com.vue.data.demo.vuerequest.mapper.UserMapper;
import com.vue.data.demo.vuerequest.pojo.Class_;
import com.vue.data.demo.vuerequest.pojo.Major;
import com.vue.data.demo.vuerequest.pojo.User;
import com.vue.data.demo.vuerequest.pojo.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
/**
 * @author hsy
 */
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
    public List<UserList> getUserList(HashMap map) {
        return userMapper.getUserList(map);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserById1(User user) {
        return userMapper.getUserById1(user);
    }

    @Override
    public int updateUser(UserList userList) {
        return userMapper.updateUser(userList);
    }

    @Override
    public Integer deleteUser(List<Integer> id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public Integer selectUserCount(String name) {
        return userMapper.selectUserCount(name);
    }

    @Override
    public int updatePwd(User user) {
        return userMapper.updatePwd(user);
    }

    @Override
    public int updateName(User user) {
        return userMapper.updateName(user);
    }

    @Override
    public List<Major> getMajorList(Major major) {
        return userMapper.getMajorList(major);
    }

    @Override
    public List<Class_> getClassList(Class_ class_) {
        return userMapper.getClassList(class_);
    }

    @Override
    public List<User> getUserList1(User user) {
        return userMapper.getUserList1(user);
    }

}
