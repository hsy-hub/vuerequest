package com.vue.data.demo.vuerequest.mapper;

import com.vue.data.demo.vuerequest.pojo.User;
import com.vue.data.demo.vuerequest.pojo.UserList1;
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
     * getUserListSearch
     * @param map
     * @return
     */
    public List<UserList1> getUserListSearch(HashMap map);
    /**
     * getUserCount
     * @param name
     * @return
     */
    public Integer getUser1Count(String name);
    /**
     *
     * @param user
     * @return
     */
    public Integer updatePwd(User user);
}
