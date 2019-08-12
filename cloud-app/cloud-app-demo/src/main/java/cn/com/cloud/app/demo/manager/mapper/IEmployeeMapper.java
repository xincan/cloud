package cn.com.cloud.app.demo.manager.mapper;

import cn.com.cloud.app.demo.manager.entity.Employee;
import cn.com.cloud.common.data.universal.IBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: mysql 用户管理数据访问接口
 */
@Repository("employeeMapper")
public interface IEmployeeMapper extends IBaseMapper<Employee> {

    /**
     * 查询mysql用户信息
     * @param map
     * @return
     */
    List<Employee> findAll(Map<String, Object> map);

}
