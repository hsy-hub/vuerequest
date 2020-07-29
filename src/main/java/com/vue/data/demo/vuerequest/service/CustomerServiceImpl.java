package com.vue.data.demo.vuerequest.service;

import com.vue.data.demo.vuerequest.mapper.CustomerMapper;
import com.vue.data.demo.vuerequest.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
/**
 * @author hsy
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public User login(User user) {
        return customerMapper.login(user);
    }

    @Override
    public User logOut(String token) {
        return customerMapper.logOut(token);
    }

    @Override
    public Integer addUser(Customer customer) {
        return customerMapper.addUser(customer);
    }


    @Override
    public Integer delUserById(Integer id) {
        return customerMapper.delUserById(id);
    }

    @Override
    public List<Customer> getUserByName(String name) {
        return customerMapper.getUserByName(name);
    }

    @Override
    public List<Customer> getUserByMajor(String majorName) {
        return customerMapper.getUserByMajor(majorName);
    }

    @Override
    public List<Customer> getUserList1(Customer customer) {
        return null;
    }

    @Override
    public List<UserList> getUserList(HashMap map) {
        return customerMapper.getUserList(map);
    }

    @Override
    public List<CusMajorClass> getUserById(HashMap map, Integer id) {
        return customerMapper.getUserById(map, id);
    }


    @Override
    public Customer getUserById1(Customer customer) {
        return null;
    }


    @Override
    public int updateUser(Customer customer) {
        return customerMapper.updateUser(customer);
    }

    @Override
    public Integer deleteUser(List<Integer> id) {
        return customerMapper.deleteUser(id);
    }

    @Override
    public Integer selectUserCount(String name) {
        return customerMapper.selectUserCount(name);
    }

    @Override
    public int updatePwd(Customer customer) {
        return customerMapper.updatePwd(customer);
    }

    @Override
    public int updateName(Customer customer) {
        return customerMapper.updateName(customer);
    }


    @Override
    public List<Major> getMajorList(Major major) {
        return customerMapper.getMajorList(major);
    }

    @Override
    public List<Class_> getClassList(Class_ class_) {
        return customerMapper.getClassList(class_);
    }


}
