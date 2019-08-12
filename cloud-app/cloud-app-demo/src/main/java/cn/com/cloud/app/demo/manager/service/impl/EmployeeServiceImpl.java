package cn.com.cloud.app.demo.manager.service.impl;

import cn.com.cloud.app.demo.manager.entity.Employee;
import cn.com.cloud.app.demo.manager.mapper.IEmployeeMapper;
import cn.com.cloud.app.demo.manager.service.IEmployeeService;
import cn.com.cloud.common.data.universal.AbstractService;
import cn.com.cloud.common.data.page.MybatisPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: 员工管理业务实现层
 */
@Service("employeeService")
@Slf4j
public class EmployeeServiceImpl extends AbstractService<Employee> implements IEmployeeService {

    @Autowired
    private IEmployeeMapper employeeMapper;


    /**
     * 根据参数分页查询员工信息
     * @param map
     * @return
     */
    @Override
    public PageInfo<Employee> findAll(Map<String, Object> map) {
        MybatisPage.getPageSize(map);
        PageHelper.startPage(MybatisPage.page, MybatisPage.limit);
        List<Employee> userInfoList = this.employeeMapper.findAll(map);
        log.info("{}", userInfoList);
        return new PageInfo<>(userInfoList);
    }


}
