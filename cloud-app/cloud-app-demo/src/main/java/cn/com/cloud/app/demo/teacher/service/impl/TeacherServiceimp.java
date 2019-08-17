package cn.com.cloud.app.demo.teacher.service.impl;

import cn.com.cloud.app.demo.teacher.entity.Teacher;
import cn.com.cloud.app.demo.teacher.mapper.TeacherMapper;
import cn.com.cloud.app.demo.teacher.service.TeacherService;
import cn.com.cloud.common.data.page.MybatisPage;
import cn.com.cloud.common.data.universal.AbstractService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Map;

@Service("teacherService")
@Slf4j
public class TeacherServiceimp extends AbstractService<Teacher> implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Override
        public  PageInfo<Teacher> findAll(Map<String, Object> map){
            MybatisPage.getPageSize(map);
            PageHelper.startPage(MybatisPage.page, MybatisPage.limit);
            List<Teacher> userInfoList = this.teacherMapper.findAll(map);
            log.info("{}", userInfoList);
            return new PageInfo<>(userInfoList);

    };

   /* @Override
    public Integer insert(Teacher model) {
        return teacherMapper.insert(model);
    }

    @Override
    public Integer deleteById(String id) {
        return teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByIds(String ids) {
        return teacherMapper.deleteByIds(ids);
    }

    @Override
    public Integer update(Teacher model) {
        return teacherMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public Teacher selectById(String id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Teacher> selectListByIds(String ids) {
        return teacherMapper.selectByIds(ids);
    }

    @Override
    public List<Teacher> selectByCondition(Condition condition) {
        return teacherMapper.selectByCondition(condition);
    }

    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public List<Teacher> select(Teacher record) {
        return teacherMapper.select(record);
    }

    @Override
    public Teacher selectOne(Teacher record) {
        return teacherMapper.selectOne(record);
    }
*/
}
