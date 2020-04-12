package com.vue.data.demo.vuerequest.controller;

import com.vue.data.demo.vuerequest.pojo.ResultList;
import com.vue.data.demo.vuerequest.pojo.User;
import com.vue.data.demo.vuerequest.service.UserService;
import com.vue.data.demo.vuerequest.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Map<String, Object> Login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        User loginUser = userService.login(user);
        if (loginUser != null) {
            String token = JwtUtil.sign(loginUser);
            map.put("data", loginUser);
            map.put("code", 1);
            map.put("msg", "登录成功");
            map.put("token", token);//传给前端
            System.out.println("token>>>" + token);
            return map;
        } else if (loginUser == null) {
            map.put("code", -1);
            map.put("msg", "用户名密码不正确");
            map.put("data", loginUser);
            return map;
        }
        return map;
    }


    @PostMapping("addUser")
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @GetMapping("delUserById/{id}")
    public int delUserById(@PathVariable("id") Integer id) {
        return userService.delUserById(id);
    }

    @PostMapping("deleteUser")
    public Integer deleteUser(String ids) { //ids是前台参数的名字
        //因为前台传的是数组所以用String[]
        String[] split = ids.split(",");
        List<Integer> ids_l = new ArrayList<>();
        for (String id : split) {
            ids_l.add(Integer.parseInt(id));//String转成int放入list对象
        }
        return userService.deleteUser(ids_l);
    }

    @PostMapping("getUserByName")
    public Map<String, Object> getUserByName(String name) {
        Map<String, Object> map = new HashMap<>();

        List<User> userList = userService.getUserByName(name);
        if (userList != null) {
            map.put("code", 0);
            map.put("data", userList);
        } else {
            map.put("code", -1);
            map.put("data", userList);
        }
        return map;
    }

    //VueDay1用的
//    @GetMapping("getUserList")
//    public List<User> getUserList(User user){
//        List<User> userList = userService.getUserList(user);
//        return userList;
//    }


    //vue1用的
//    @GetMapping("getUserList")
//    public ResultList getUserList(){
//        ResultList resultList = new ResultList();
//
//        List<User> userList = userService.getUserList();
//        if (userList != null){
//            resultList.setCode(0);
//            resultList.setData(userList);
//        }else{
//            resultList.setCode(-1);
//        }
//        return resultList;
//    }

    @PostMapping("getUserPageSearch")
    public Map<String, Object> getUserList(String name, Integer currentPage, Integer pageSize) {
// 可选的int参数“currentPage”存在，但由于被声明为基元类型，因此无法转换为空值.而上面代码参数currentPage,pageSize的类型 为 int，它接受不了null值。
// 解决方法:将int 改为 对象类型 Integer
        HashMap map = new HashMap();
        Map<String, Object> remap = new HashMap<>();
//      Integer pageStart = (currentPage-1)*pageSize;
        map.put("pageStart", (currentPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("name", name);
        List<User> userList = userService.getUserList(map);
        if (userList != null) {
            remap.put("code", 0);
            remap.put("data", userList);
        } else {
            remap.put("code", -1);
            remap.put("msg", "请登录");
        }
        return remap;
    }

    @GetMapping("getUserCount")
    public Map<String, Object> selectUserCount(String name) {
        Map<String, Object> map = new HashMap<>();
        Integer count = userService.selectUserCount(name);
        if (count != null) {
            map.put("code", 0);
            map.put("result", count);
        }
        return map;
    }

    @GetMapping("getUserById/{id}")
    public Map<String, Object> getUserById(@PathVariable("id") Integer id) {
        Map<String, Object> map = new HashMap<>();
        User user = userService.getUserById(id);
        if (user != null) {
            map.put("code", 0);
            map.put("result", user);
        }
        return map;
    }

    @PostMapping("updateUser")
    public Map<String, Object> updateUser(User user) {
        Map<String, Object> map = new HashMap<>();
        Integer i = userService.updateUser(user);
        String msg = "";
        if (i != null) {
            map.put("code", 0);
            msg = "修改成功";
        } else {
            map.put("code", -1);
            msg = "修改失败";
        }
        map.put("msg", msg);
        return map;
    }

    @PostMapping("imagesUpload")
    public String imagesUpload(MultipartFile file) {
        String filePath = "d:/myImage"; //上传路径
        String fileName = file.getOriginalFilename(); //文件名
        String suffix = fileName.substring(fileName.lastIndexOf(".")); //取的文件的后缀名
        fileName = UUID.randomUUID() + suffix; //新的文件名 防止同名上传时覆盖
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest); //上传文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}


