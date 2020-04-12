package com.vue.data.demo.vuerequest.mapper;

import com.vue.data.demo.vuerequest.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public User login(User user);
    public Integer addUser(User user);
    public Integer delUserById(Integer id);
    public List<User> getUserByName(String name);
//    public List<User> getUserList(User user);
    public List<User> getUserList(HashMap map);
    public User getUserById(Integer id);
    public int updateUser(User user);
    public Integer deleteUser(List<Integer> id);
    public Integer selectUserCount(String name);
}
