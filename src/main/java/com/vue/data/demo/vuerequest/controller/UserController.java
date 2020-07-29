package com.vue.data.demo.vuerequest.controller;

import com.vue.data.demo.vuerequest.pojo.ClassRoom;
import com.vue.data.demo.vuerequest.pojo.User;
import com.vue.data.demo.vuerequest.pojo.UserList;
import com.vue.data.demo.vuerequest.pojo.UserList1;
import com.vue.data.demo.vuerequest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hsy
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("getUserListSearch")
    public Map<String, Object> getUserListSearch(String name, Integer currentPage, Integer pageSize) {
// 可选的int参数“currentPage,pageSize的类型”存在，但由于被声明为基元类型，因此无法转换为空值.而上面代码参数currentPage,pageSize的类型 为 int，它接受不了null值。
// 解决方法:将int 改为 对象类型 Integer
        HashMap map = new HashMap();
        Map<String, Object> remap = new HashMap<>();
        Integer pageStart = (currentPage-1)*pageSize;
        map.put("pageStart", pageStart);
        map.put("pageSize", pageSize);
        map.put("name", name);
        List<UserList1> userList1 = userService.getUserListSearch(map);
        if (userList1 != null) {
            remap.put("code", 0);
            remap.put("data", userList1);
        } else {
            remap.put("code", -1);
            remap.put("msg", "请登录");
        }
        return remap;
    }

    @GetMapping("getUser1Count")
    public Map<String, Object> selectUserCount(String name) {
        Map<String, Object> map = new HashMap<>();
        Integer count = userService.getUser1Count(name);
        if (count != null) {
            map.put("code", 0);
            map.put("result", count);
        }
        return map;
    }

    /**
     * updatePwd 修改登录者的密码
     * @param user
     * @return
     */
    @PostMapping("updatePwd")
    public Map<String, Object> updatePwd(User user) {
        Map<String, Object> map = new HashMap<>();
        Integer integer = userService.updatePwd(user);
        String msg = "";
        if (integer != null) {
            map.put("code", 0);
            msg = "修改成功";
        } else {
            map.put("code", -1);
            msg = "修改失败";
        }
        map.put("msg", msg);
        return map;
    }

}
