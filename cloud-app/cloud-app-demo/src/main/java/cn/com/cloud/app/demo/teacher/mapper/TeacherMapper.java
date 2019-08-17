package cn.com.cloud.app.demo.teacher.mapper;


import cn.com.cloud.app.demo.teacher.entity.Teacher;
import cn.com.cloud.common.data.universal.IBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("teacherMapper")
public interface TeacherMapper extends IBaseMapper<Teacher> {

    /**
     * 查询mysql用户信息
     * @param map
     * @return
     */
  List<Teacher> findAll(Map<String, Object> map);

 /* int insert(Teacher teacher);*/

}
