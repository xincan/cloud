package cn.com.cloud.app.demo.manager.service;


import cn.com.cloud.app.demo.manager.entity.Employee;
import cn.com.cloud.common.data.universal.IBaseService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: 员工管理接口层
 */
public interface IEmployeeService extends IBaseService<Employee> {

    /**
     * 根据条件分页查询员工信息
     * @param map
     * @return
     */
    PageInfo<Employee> findAll(Map<String, Object> map);
}
