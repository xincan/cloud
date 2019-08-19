package cn.com.cloud.app.demo.grade.service;

import cn.com.cloud.app.demo.grade.entity.Grade;
import cn.com.cloud.common.data.universal.IBaseService;

import java.util.List;

public interface GradeService  extends IBaseService<Grade> {
    List<Grade> findBypid(String pid);
}
