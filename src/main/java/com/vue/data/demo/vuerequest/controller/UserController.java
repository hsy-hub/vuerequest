package com.vue.data.demo.vuerequest.controller;

import com.vue.data.demo.vuerequest.pojo.*;
import com.vue.data.demo.vuerequest.service.UserService;
import com.vue.data.demo.vuerequest.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
/**
 * @author hsy
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        User loginUser = userService.login(user);
        if (loginUser != null) {
            String token = JwtUtil.sign(loginUser);
            map.put("data", loginUser);
            map.put("code", 1);
            map.put("msg", "登录成功");
            //传给前端
            map.put("token", token);
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

    public Integer deleteUser(String ids) {
        //ids是前台参数的名字
        //因为前台传的是数组所以用String[]
        String[] split = ids.split(",");
        List<Integer> ids_l = new ArrayList<>();
        for (String id : split) {
            //String转成int放入list对象
            ids_l.add(Integer.parseInt(id));
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


    @GetMapping("getUserList1")
    public ResultList getUserList1(User user){
        ResultList resultList = new ResultList();
        List<User> userList = userService.getUserList1(user);
        if (userList != null){
            resultList.setCode(0);
            resultList.setData(userList);
        }else{
            resultList.setCode(-1);
        }
        return resultList;
    }

    @GetMapping("getMajorList")
    public Map<String,Object> getMajorList(Major major){
        Map<String,Object> map = new HashMap<>();
        List<Major> majorList = userService.getMajorList(major);
        if (majorList != null){
            map.put("code",0);
            map.put("data",majorList);
        }
       return map;
    }

    @GetMapping("getClassList")
    public Map<String,Object> getClassList(Class_ class_){
        Map<String,Object> map = new HashMap<>();
        List<Class_> classList = userService.getClassList(class_);
        if (classList != null){
            map.put("code",0);
            map.put("data",classList);
        }
        return map;
    }

    @PostMapping("getUserPageSearch")
    public Map<String, Object> getUserList(String name, Integer currentPage, Integer pageSize) {
// 可选的int参数“currentPage,pageSize的类型”存在，但由于被声明为基元类型，因此无法转换为空值.而上面代码参数currentPage,pageSize的类型 为 int，它接受不了null值。
// 解决方法:将int 改为 对象类型 Integer
        HashMap map = new HashMap();
        Map<String, Object> remap = new HashMap<>();
        Integer pageStart = (currentPage-1)*pageSize;
        map.put("pageStart", pageStart);
        map.put("pageSize", pageSize);
        map.put("name", name);
        List<UserList> userList = userService.getUserList(map);
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
            map.put("data", user);
        }
        return map;
    }

    @PostMapping("getUserById1")
    public Map<String, Object> getUserById1(User user) {
        Map<String, Object> map = new HashMap<>();
       User user1 = userService.getUserById1(user);
        if (user1 != null) {
            map.put("code", 0);
            map.put("result", user);
        }
        return map;
    }

    @PostMapping("updateUser")
    public Map<String, Object> updateUser(UserList userList) {
        Map<String, Object> map = new HashMap<>();
        Integer i = userService.updateUser(userList);
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

    @PostMapping("updatePwd")
    public Map<String, Object> updatePwd(User user) {
        Map<String, Object> map = new HashMap<>();
        Integer i = userService.updatePwd(user);
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

    @PostMapping("updateName")
    public Map<String, Object> updateName(User user) {
        Map<String, Object> map = new HashMap<>();
        Integer i = userService.updateName(user);
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
    public Map<String,Object> imagesUpload(MultipartFile file) {
        Map<String,Object> map = new HashMap<>();
        String filePath = "d:/myImage/";
        //上传路径
        String fileName = file.getOriginalFilename();
        //文件名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //取的文件的后缀名
        fileName = UUID.randomUUID() + suffix;
        //新的文件名 防止同名上传时覆盖
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            //上传文件
            map.put("code",0);
            map.put("filePath",filePath);
            map.put("fileName",fileName);
            map.put("msg","上传成功");
        } catch (IOException e) {
            map.put("code",-1);
            map.put("filePath",null);
            map.put("fileName",null);
            map.put("msg","上传失败");
            e.printStackTrace();
        }
        return map;
    }

//    @PostMapping("imagesUpload")
//    public String imagesUpload(MultipartFile file) {
//        String filePath = "d:/myImage/"; //上传路径
//        String fileName = file.getOriginalFilename(); //文件名
//        String suffix = fileName.substring(fileName.lastIndexOf(".")); //取的文件的后缀名
//        fileName = UUID.randomUUID() + suffix; //新的文件名 防止同名上传时覆盖
//        File dest = new File(filePath + fileName);
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(dest); //上传文件
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return fileName;
//    }
}


