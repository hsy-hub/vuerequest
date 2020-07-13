package com.vue.data.demo.vuerequest.mapper;

import com.vue.data.demo.vuerequest.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
/**
 * @author hsy
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * login
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * addUser
     * @param user
     * @return
     */
    public Integer addUser(User user);

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
    public List<User> getUserByName(String name);

    /**
     * getUserList1
     * @param user
     * @return
     */
    public List<User> getUserList1(User user);

    /**
     * getUserList
     * @param map
     * @return
     */
    public List<User> getUserList(HashMap map);

    /**
     * getUserById
     * @param id
     * @return
     */
    public User getUserById(Integer id);

    /**
     * getUserById1
     * @param user
     * @return
     */
    public User getUserById1(User user);

    /**
     * updateUser
     * @param user
     * @return
     */
    public int updateUser(User user);

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
     * @param user
     * @return
     */
    public int updatePwd(User user);

    /**
     * updateName
     * @param user
     * @return
     */
    public int updateName(User user);
}
