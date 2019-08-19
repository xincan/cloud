package cn.com.cloud.app.demo.grade.service.impl;

import cn.com.cloud.app.demo.grade.entity.Grade;
import cn.com.cloud.app.demo.grade.mapper.GradeMapper;
import cn.com.cloud.app.demo.grade.service.GradeService;
import cn.com.cloud.common.data.universal.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gradeService")
@Slf4j
public class GradeServiceimpl extends AbstractService<Grade> implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;


    @Override
    public List<Grade> findBypid(String pid) {
        return gradeMapper.findBypid(pid);
    }
}
