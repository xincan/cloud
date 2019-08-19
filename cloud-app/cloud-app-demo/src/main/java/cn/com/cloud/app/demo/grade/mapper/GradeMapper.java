package cn.com.cloud.app.demo.grade.mapper;

import cn.com.cloud.app.demo.grade.entity.Grade;
import cn.com.cloud.common.data.universal.IBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("gradeMapper")
public interface GradeMapper extends IBaseMapper<Grade> {


    List<Grade> findBypid(String pid);
}
