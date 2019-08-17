package cn.com.cloud.app.demo.student.service;

import cn.com.cloud.app.demo.student.entity.Student;
import cn.com.cloud.common.data.universal.IBaseService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface StudentService extends IBaseService<Student> {
    /**
     * 根据条件分页查询员工信息
     * @param map
     * @return
     */
    PageInfo<Student> findAll(Map<String, Object> map);
}
