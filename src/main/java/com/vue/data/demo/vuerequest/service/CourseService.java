package com.vue.data.demo.vuerequest.service;
import com.vue.data.demo.vuerequest.pojo.ClassRoom;
import com.vue.data.demo.vuerequest.pojo.Course;

import java.util.HashMap;
import java.util.List;
/**
 * @author hsy
 */
public interface CourseService {
    /**
     * getCourseList
     * @param map
     * @return
     */
    public List<Course> getCourseList(HashMap map);
    /**
     * selectCourseCount
     * @param courseName
     * @return
     */
    public Integer selectCourseCount(String courseName);

    /**
     * selectClassRoom
     * @param map
     * @return
     */
    public List<ClassRoom> selectClassRoom(HashMap map);

    /**
     * selectClassRoomCount
     * @param classnum
     * @return
     */
    public Integer selectClassRoomCount(String classnum);

    /**
     * updateYn
     * @param classRoom
     * @return
     */
    public int updateYn(ClassRoom classRoom);

}