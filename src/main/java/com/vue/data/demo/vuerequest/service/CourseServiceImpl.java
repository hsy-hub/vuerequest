package com.vue.data.demo.vuerequest.service;

import com.vue.data.demo.vuerequest.mapper.CourseMapper;
import com.vue.data.demo.vuerequest.pojo.ClassRoom;
import com.vue.data.demo.vuerequest.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author hsy
 */
@Service
public class CourseServiceImpl implements CourseService{
@Autowired
    CourseMapper courseMapper;
    @Override
    public List<Course> getCourseList(HashMap map) {
        return courseMapper.getCourseList(map);
    }

    @Override
    public Integer selectCourseCount(String courseName) {
        return courseMapper.selectCourseCount(courseName);
    }

    @Override
    public List<ClassRoom> selectClassRoom(HashMap map) {
        return courseMapper.selectClassRoom(map);
    }

    @Override
    public Integer selectClassRoomCount(String classnum) {
        return courseMapper.selectClassRoomCount(classnum);
    }

    @Override
    public int updateYn(ClassRoom classRoom) {
        return courseMapper.updateYn(classRoom);
    }

    @Override
    public ClassRoom getRoomById(Integer id) {
        return courseMapper.getRoomById(id);
    }
}
