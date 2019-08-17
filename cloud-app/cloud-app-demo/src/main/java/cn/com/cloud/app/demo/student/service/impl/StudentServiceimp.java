package cn.com.cloud.app.demo.student.service.impl;


import cn.com.cloud.app.demo.student.entity.Student;
import cn.com.cloud.app.demo.student.mapper.StudentMapper;
import cn.com.cloud.app.demo.student.service.StudentService;
import cn.com.cloud.common.data.page.MybatisPage;
import cn.com.cloud.common.data.universal.AbstractService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
@Service("studentService")
@Slf4j
public class StudentServiceimp  extends AbstractService<Student> implements StudentService {


    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageInfo<Student> findAll(Map<String, Object> map) {
        MybatisPage.getPageSize(map);
        PageHelper.startPage(MybatisPage.page, MybatisPage.limit);
        List<Student> userInfoList = this.studentMapper.findAll(map);
        log.info("{}", userInfoList);
        return new PageInfo<>(userInfoList);
    }
/*
    @Override
    public Integer insert(Student model) {
        return studentMapper.insert(model);
    }

    @Override
    public Integer deleteById(String id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByIds(String ids) {
        return studentMapper.deleteByIds(ids);
    }

    @Override
    public Integer update(Student model) {
        return studentMapper.updateByPrimaryKey(model);
    }

    @Override
    public Student selectById(String id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> selectListByIds(String ids) {
        return null;
    }


    @Override
    public List<Student> selectByCondition(Condition condition) {
        return null;
    }

    @Override
    public List<Student> selectAll() {
        return null;
    }

    @Override
    public List<Student> select(Student record) {
        return null;
    }

    @Override
    public Student selectOne(Student record) {
        return null;
    }*/
}
