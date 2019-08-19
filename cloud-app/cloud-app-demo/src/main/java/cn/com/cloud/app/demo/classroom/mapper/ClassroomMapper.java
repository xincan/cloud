package cn.com.cloud.app.demo.classroom.mapper;

import cn.com.cloud.app.demo.classroom.entity.Classroom;
import cn.com.cloud.common.data.universal.IBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository("classroomMapper")
public interface ClassroomMapper extends IBaseMapper<Classroom> {
    List<Classroom> findAll(Map<String, Object> map);
}
