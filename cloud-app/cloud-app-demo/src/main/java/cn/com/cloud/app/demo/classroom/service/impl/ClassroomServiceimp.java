package cn.com.cloud.app.demo.classroom.service.impl;

import cn.com.cloud.app.demo.classroom.entity.Classroom;
import cn.com.cloud.app.demo.classroom.mapper.ClassroomMapper;
import cn.com.cloud.app.demo.classroom.service.ClassroomService;
import cn.com.cloud.common.data.page.MybatisPage;
import cn.com.cloud.common.data.universal.AbstractService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service("classroomService")
@Slf4j
public class ClassroomServiceimp extends AbstractService<Classroom> implements ClassroomService {
    @Autowired
    private ClassroomMapper classroomMapper;


    /**
     * 根据参数分页查询class信息
     * @param map
     * @return
     */
    @Override
    public PageInfo<Classroom> findAll(Map<String, Object> map) {
        MybatisPage.getPageSize(map);
        PageHelper.startPage(MybatisPage.page, MybatisPage.limit);
        List<Classroom> userInfoList = this.classroomMapper.findAll(map);
        log.info("{}", userInfoList);
        return new PageInfo<>(userInfoList);
    }

}
