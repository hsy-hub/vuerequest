package com.vue.data.demo.vuerequest.mapper;

import com.vue.data.demo.vuerequest.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public Integer addUser(User user);
    public Integer delUserById(Integer id);
    public List<User> getUserList(User user);
}
