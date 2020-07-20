package com.vue.data.demo.vuerequest.mapper;

import com.vue.data.demo.vuerequest.pojo.ClassRoom;
import com.vue.data.demo.vuerequest.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author hsy
 */
@Mapper
@Repository
public interface CourseMapper {
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

//    public Product getProductById(Integer id);

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
