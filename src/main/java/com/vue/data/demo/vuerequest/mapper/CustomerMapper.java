package com.vue.data.demo.vuerequest.mapper;

import com.vue.data.demo.vuerequest.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
/**
 * @author hsy
 */
@Mapper
@Repository
public interface CustomerMapper {
    /**
     * login
     * @param user
     * @return
     */
    public User login(User user);
    /**
     * logOut
     * @param token
     * @return
     */
    public User logOut(String token);

    /**
     * addUser
     * @param customer
     * @return
     */
    public Integer addUser(Customer customer);

    /**
     * delUserById
     * @param id
     * @return id
     */
    public Integer delUserById(Integer id);

    /**
     * getUserByName
     * @param name
     * @return
     */
    public List<Customer> getUserByName(String name);

    /**
     * getUserByMajor
     * @param majorName
     * @return
     */
    public List<Customer> getUserByMajor(String majorName);

    /**
     * getUserList1
     * @param customer
     * @return
     */
    public List<Customer> getUserList1(Customer customer);

    /**
     * getUserList
     * @param map
     * @return
     */
    public List<UserList> getUserList(HashMap map);

    /**
     * getUserById
     * @param id
     * @return
     */
    public List<CusMajorClass> getUserById(HashMap map,Integer id);

    /**
     * getUserById1
     * @param customer
     * @return
     */
    public Customer getUserById1(Customer customer);

    /**
     * updateUser
     * @param customer
     * @return
     */
    public int updateUser(Customer customer);

    /**
     * deleteUser
     * @param id
     * @return
     */
    public Integer deleteUser(List<Integer> id);

    /**
     * selectUserCount
     * @param name
     * @return
     */
    public Integer selectUserCount(String name);

    /**
     * updatePwd
     * @param customer
     * @return
     */
    public int updatePwd(Customer customer);

    /**
     * updateName
     * @param customer
     * @return
     */
    public int updateName(Customer customer);

    /**
     * getMajorList
     * @param major
     * @return
     */
    public List<Major> getMajorList(Major major);
    /**
     * getClassList
     * @param class_
     * @return
     */
    public List<Class_> getClassList(Class_ class_);
}
