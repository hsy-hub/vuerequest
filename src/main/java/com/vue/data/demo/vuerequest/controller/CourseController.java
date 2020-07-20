package com.vue.data.demo.vuerequest.controller;

import com.vue.data.demo.vuerequest.pojo.ClassRoom;
import com.vue.data.demo.vuerequest.pojo.Course;
import com.vue.data.demo.vuerequest.pojo.UserList;
import com.vue.data.demo.vuerequest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author hsy
 */
@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

//    @GetMapping("getProductById/{id}")
//    public Map<String, Object> getProductById(@PathVariable("id") Integer id) {
//        Map<String, Object> map = new HashMap<>();
//        Product product = productService.getProductById(id);
//        if (product != null) {
//            map.put("code", 0);
//            map.put("result", product);
//        }
//        return map;
//    }

    /**
     * getCourseSearch 查询出所有课程课程
     * @param courseName
     * @param currentPage
     * @param pageSize
     * @return
     */
    @PostMapping("getCourseSearch")
    public Map<String, Object> getCourseSearch(String courseName, Integer currentPage, Integer pageSize) {
// 可选的int参数“currentPage,pageSize的类型”存在，但由于被声明为基元类型，因此无法转换为空值.而上面代码参数currentPage,pageSize的类型 为 int，它接受不了null值。
// 解决方法:将int 改为 对象类型 Integer
        HashMap map = new HashMap();
        Map<String, Object> remap = new HashMap<>();
        Integer pageStart = (currentPage-1)*pageSize;
        map.put("pageStart", pageStart);
        map.put("pageSize", pageSize);
        map.put("courseName", courseName);
        List<Course> courseList = courseService.getCourseList(map);
        if (courseList != null) {
            remap.put("code", 0);
            remap.put("data", courseList);
        } else {
            remap.put("code", -1);
            remap.put("msg", "请登录");
        }
        return remap;
    }

    /**
     * getCourseCount 查询出课程的数量
     * @param courseName
     * @return
     */
    @GetMapping("getCourseCount")
    public Map<String, Object> getCourseCount(String courseName) {
        Map<String, Object> map = new HashMap<>();
        Integer count = courseService.selectCourseCount(courseName);
        if (count != null) {
            map.put("code", 0);
            map.put("result", count);
        }
        return map;
    }

    /**
     * selectClassRoom 查询出所有教室
     * @param classnum
     * @param currentPage
     * @param pageSize
     * @return
     */
    @PostMapping("selectClassRoom")
    public Map<String, Object> selectClassRoom(String classnum, Integer currentPage, Integer pageSize) {
// 可选的int参数“currentPage,pageSize的类型”存在，但由于被声明为基元类型，因此无法转换为空值.而上面代码参数currentPage,pageSize的类型 为 int，它接受不了null值。
// 解决方法:将int 改为 对象类型 Integer
        HashMap map = new HashMap();
        Map<String, Object> remap = new HashMap<>();
        Integer pageStart = (currentPage-1)*pageSize;
        map.put("pageStart", pageStart);
        map.put("pageSize", pageSize);
        map.put("classnum", classnum);
        List<ClassRoom> roomList = courseService.selectClassRoom(map);
        if (roomList != null) {
            remap.put("code", 0);
            remap.put("data", roomList);
        } else {
            remap.put("code", -1);
            remap.put("msg", "请登录");
        }
        return remap;
    }

    /**
     * selectClassRoomCount 查询出教室的数量
     * @param classnum
     * @return
     */
    @GetMapping("selectClassRoomCount")
    public Map<String, Object> selectClassRoomCount(String classnum) {
        Map<String, Object> map = new HashMap<>();
        Integer count = courseService.selectClassRoomCount(classnum);
        if (count != null) {
            map.put("code", 0);
            map.put("result", count);
        }
        return map;
    }

    /**
     * updateYn 修改教室是否为空
     * @param classRoom
     * @return
     */
    @PostMapping("updateYn")
    public Map<String, Object> updateYn(ClassRoom classRoom) {
        Map<String, Object> map = new HashMap<>();
        Integer i = courseService.updateYn(classRoom);
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
}
