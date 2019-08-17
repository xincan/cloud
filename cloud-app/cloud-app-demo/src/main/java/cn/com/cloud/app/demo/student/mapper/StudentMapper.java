package cn.com.cloud.app.demo.student.mapper;

import cn.com.cloud.app.demo.student.entity.Student;
import cn.com.cloud.common.data.universal.IBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("studentMapper")
public interface StudentMapper extends IBaseMapper<Student> {

    /**
     * 查询mysql用户信息
     * @param map
     * @return
     */
    List<Student> findAll(Map<String, Object> map);
}
