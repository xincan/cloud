package cn.com.cloud.app.demo.teacher.service;


import cn.com.cloud.app.demo.teacher.entity.Teacher;
import cn.com.cloud.common.data.universal.IBaseService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface TeacherService extends IBaseService<Teacher> {
    PageInfo<Teacher> findAll(Map<String, Object> map);

}
