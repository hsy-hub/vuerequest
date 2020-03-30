package com.vue.data.demo.vuerequest.controller;

import com.vue.data.demo.vuerequest.pojo.User;
import com.vue.data.demo.vuerequest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("addUser")
    public int addUser(User user){
        Integer integer = userService.addUser(user);
        return integer;
    }

    @GetMapping("delUserById/{id}")
    public int delUserById(@PathVariable("id") Integer id){
        Integer integer = userService.delUserById(id);
        return integer;
    }

    @GetMapping("getUserList")
    public List<User> getUserList(User user){
        List<User> userlist = userService.getUserList(user);
        return userlist;
    }
}

