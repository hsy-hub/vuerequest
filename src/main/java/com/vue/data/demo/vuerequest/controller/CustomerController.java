package com.vue.data.demo.vuerequest.controller;

import com.vue.data.demo.vuerequest.pojo.*;
import com.vue.data.demo.vuerequest.service.CustomerService;
import com.vue.data.demo.vuerequest.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;
/**
 * @author hsy
 */
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    /**
     * login 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        User loginUser = customerService.login(user);
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

    @Autowired
    HttpServletRequest request;
    @PostMapping("logOut")
    public Map<String, Object> logOut() {

        String token = request.getHeader("Authorization");
        Map<String, Object> map = new HashMap<>();
        map.put("token", null);
        return map;
    }

    /**
     * addUser 添加学生
     * @param user
     * @return
     */
    @PostMapping("addUser")
    public int addUser(Customer user) {
        return customerService.addUser(user);
    }

    /**
     * delUserById 单个删除学生
     * @param id
     * @return
     */
    @GetMapping("delUserById/{id}")
    public int delUserById(@PathVariable("id") Integer id) {
        return customerService.delUserById(id);
    }

    /**
     * deleteUser 批量删除学生
     * @param ids
     * @return
     */
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
        return customerService.deleteUser(ids_l);
    }

    /**
     * getUserByName 根据学生姓名查找
     * @param name
     * @return
     */
    @PostMapping("getUserByName")
    public Map<String, Object> getUserByName(String name) {
        Map<String, Object> map = new HashMap<>();

        List<Customer> userList = customerService.getUserByName(name);
        if (userList != null) {
            map.put("code", 0);
            map.put("data", userList);
        } else {
            map.put("code", -1);
            map.put("data", userList);
        }
        return map;
    }

//    @PostMapping("getUserByMajor")
//    public Map<String, Object> getUserByMajor(String majorName) {
//        Map<String, Object> map = new HashMap<>();
//
//        List<Customer> userList = customerService.getUserByName(majorName);
//        if (userList != null) {
//            map.put("code", 0);
//            map.put("data", userList);
//        } else {
//            map.put("code", -1);
//            map.put("data", userList);
//        }
//        return map;
//    }

    //VueDay1用的
//    @GetMapping("getUserList")
//    public List<User> getUserList(User user){
//        List<User> userList = userService.getUserList(user);
//        return userList;
//    }


//    @GetMapping("getUserList1")
//    public ResultList getUserList1(User user){
//        ResultList resultList = new ResultList();
//        List<User> userList = userService.getUserList1(user);
//        if (userList != null){
//            resultList.setCode(0);
//            resultList.setData(userList);
//        }else{
//            resultList.setCode(-1);
//        }
//        return resultList;
//    }

    /**
     * getMajorList 得到所有专业
     * @param major
     * @return
     */
    @GetMapping("getMajorList")
    public Map<String,Object> getMajorList(Major major){
        Map<String,Object> map = new HashMap<>();
        List<Major> majorList = customerService.getMajorList(major);
        if (majorList != null){
            map.put("code",0);
            map.put("data",majorList);
        }
       return map;
    }

    /**
     * getClassList 得到所有班级
     * @param class_
     * @return
     */
    @GetMapping("getClassList")
    public Map<String,Object> getClassList(Class_ class_){
        Map<String,Object> map = new HashMap<>();
        List<Class_> classList = customerService.getClassList(class_);
        if (classList != null){
            map.put("code",0);
            map.put("data",classList);
        }
        return map;
    }

    /**
     * getUserPageSearch 得到所有学生的信息 带分页
     * @param name
     * @param currentPage
     * @param pageSize
     * @return
     */
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
        List<UserList> userList = customerService.getUserList(map);
        if (userList != null) {
            remap.put("code", 0);
            remap.put("data", userList);
        } else {
            remap.put("code", -1);
            remap.put("msg", "请登录");
        }
        return remap;
    }

    /**
     * getUserCount 查询出学生的数量
     * @param name
     * @return
     */
    @GetMapping("getUserCount")
    public Map<String, Object> selectUserCount(String name) {
        Map<String, Object> map = new HashMap<>();
        Integer count = customerService.selectUserCount(name);
        if (count != null) {
            map.put("code", 0);
            map.put("result", count);
        }
        return map;
    }

    /**
     *getUserById 根据学生的id查询出该学生的信息
     * 回填数据的时候会用到
     * @param id
     * @return
     */
    @GetMapping("getUserById/{id}")
    public Map<String, Object> getUserById(@PathVariable("id")Integer id,HashMap map) {
        Map<String, Object> map1 = new HashMap<>();
        List<CusMajorClass> userById = customerService.getUserById(map, id);
        if (userById != null) {
            map1.put("code", 0);
            map1.put("data", userById);
        }
        return map1;
    }

//    @PostMapping("getUserById1")
//    public Map<String, Object> getUserById1(User user) {
//        Map<String, Object> map = new HashMap<>();
//       User user1 = userService.getUserById1(user);
//        if (user1 != null) {
//            map.put("code", 0);
//            map.put("result", user);
//        }
//        return map;
//    }

    /**
     * updateUser 修改学生的信息 在确认修改后将数据传给后台进行修改
     * @param customer);
     *         String msg = "";
     *         if
     * @return
     */
    @PostMapping("updateUser")
    public Map<String, Object> updateUser(Customer customer) {
        Map<String, Object> map = new HashMap<>();
        Integer i = customerService.updateUser(customer);
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

//    @PostMapping("updateName")
//    public Map<String, Object> updateName(Customer user) {
//        Map<String, Object> map = new HashMap<>();
//        Integer i = userService.updateName(user);
//        String msg = "";
//        if (i != null) {
//            map.put("code", 0);
//            msg = "修改成功";
//        } else {
//            map.put("code", -1);
//            msg = "修改失败";
//        }
//        map.put("msg", msg);
//        return map;
//    }

//    @PostMapping("imagesUpload")
//    public Map<String,Object> imagesUpload(MultipartFile file) {
//        Map<String,Object> map = new HashMap<>();
//        String filePath = "d:/myImage/";
//        //上传路径
//        String fileName = file.getOriginalFilename();
//        //文件名
//        String suffix = fileName.substring(fileName.lastIndexOf("."));
//        //取的文件的后缀名
//        fileName = UUID.randomUUID() + suffix;
//        //新的文件名 防止同名上传时覆盖
//        File dest = new File(filePath + fileName);
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(dest);
//            //上传文件
//            map.put("code",0);
//            map.put("filePath",filePath);
//            map.put("fileName",fileName);
//            map.put("msg","上传成功");
//        } catch (IOException e) {
//            map.put("code",-1);
//            map.put("filePath",null);
//            map.put("fileName",null);
//            map.put("msg","上传失败");
//            e.printStackTrace();
//        }
//        return map;
//    }

    @PostMapping("imagesUpload")
    public String imagesUpload(MultipartFile file) {
        String filePath = "d:/myImage/"; //上传路径
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


