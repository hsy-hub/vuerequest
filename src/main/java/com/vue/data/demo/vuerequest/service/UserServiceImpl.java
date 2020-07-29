package com.vue.data.demo.vuerequest.service;

import com.vue.data.demo.vuerequest.mapper.UserMapper;
import com.vue.data.demo.vuerequest.pojo.User;
import com.vue.data.demo.vuerequest.pojo.UserList1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author hsy
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserList1> getUserListSearch(HashMap map) {
        return userMapper.getUserListSearch(map);
    }

    @Override
    public Integer getUser1Count(String name) {
        return userMapper.getUser1Count(name);
    }

    @Override
    public Integer updatePwd(User user) {
        return userMapper.updatePwd(user);
    }

}
