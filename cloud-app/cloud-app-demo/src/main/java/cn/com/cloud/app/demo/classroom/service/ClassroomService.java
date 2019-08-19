package cn.com.cloud.app.demo.classroom.service;

import cn.com.cloud.app.demo.classroom.entity.Classroom;
import cn.com.cloud.common.data.universal.IBaseService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.Map;


public interface ClassroomService extends IBaseService<Classroom> {
    /**
     * 根据条件分页查询员工信息
     * @param map
     * @return
     */
    public abstract PageInfo<Classroom> findAll(Map<String, Object> map);

}
