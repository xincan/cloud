package cn.com.cloud.app.demo.manager.controller;

import cn.com.cloud.app.demo.manager.entity.Employee;
import cn.com.cloud.app.demo.manager.service.IEmployeeService;
import cn.com.cloud.common.data.result.ResultObject;
import cn.com.cloud.common.data.result.ResultResponse;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: 员工管理控制层
 */
@Api(tags = {"员工管理"})
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    /**
     * @Author Xincan
     * @Version  1.0
     * @Description 注入员工业务接口
     * @Date 2019-1-10 1:58
     */
    @Autowired
    private IEmployeeService employeeService;


    @ApiOperation(value="添加员工信息",httpMethod="POST",notes="根据参数列表添加员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="真实名称", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sex",value="用户性别", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="age",value="用户年龄", dataType = "int",paramType = "query")
    })
    @PostMapping("/insert")
    public ResultObject<Object> insert(@ApiParam(hidden = true) @RequestParam Map<String,Object> map){
        Employee employee = JSON.parseObject(JSON.toJSONString(map), Employee.class);
        int num = this.employeeService.insert(employee);
        if(num>0){
            log.info("{}", "添加员工信息成功");
            return ResultResponse.success("添加员工成功",employee);
        }
        log.info("{}", "添加员工信息失败");
        return ResultResponse.error("添加员工失败");
    }

    @ApiOperation(value="修改员工信息",httpMethod="POST", notes="根据员工ID，修改参数列表中对应的员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="员工ID", dataType = "String", required = true,paramType = "query"),
            @ApiImplicitParam(name="name",value="真实名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sex",value="用户性别", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="age",value="用户年龄", dataType = "int",paramType = "query")
    })
    @PostMapping({"/update"})
    public ResultObject<Object> update(@ApiParam(hidden = true) @RequestParam Map<String,Object> map){
        Employee employee = JSON.parseObject(JSON.toJSONString(map), Employee.class);
        int num = this.employeeService.update(employee);
        if(num>0){
            log.info("{}", "修改员工成功");
            return ResultResponse.success("修改员工成功", employee);
        }
        log.info("{}", "修改员工失败");
        return ResultResponse.error("修改员工失败",employee);
    }

    @ApiOperation(value="删除员工详细信息",httpMethod = "POST", notes="根据用户ID，删除员工详细信息（支持批量删除ID用','英文逗号隔开）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "员工ID(多个用英文、号隔开)", required = true, dataType = "String", paramType="query")
    })
    @PostMapping("/delete")
    public ResultObject<Object> delete(@RequestParam  String id) {
        int num = this.employeeService.deleteByIds(id);
        if(num > 0){
            log.info("{}", "删除员工成功");
            return  ResultResponse.success("删除员工成功", id);
        }
        log.info("{}", "删除员工失败");
        return ResultResponse.error("删除员工失败", id);
    }

    @ApiOperation(value = "查询员工信息", httpMethod = "GET", notes = "根据查询条件分页查询员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页数", defaultValue="0", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="size",value="每页条数", defaultValue="10", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="sortName",value="排序字段名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sortOrder",value="排序规则(ASC,DESC)，默认DESC", defaultValue = "DESC",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="startTime",value="开始时间", dataType = "Date",paramType = "query"),
            @ApiImplicitParam(name="endTime",value="结束时间", dataType = "Date",paramType = "query"),

            @ApiImplicitParam(name="id",value="用户ID", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="name",value="真实名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sex",value="用户性别", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="age",value="用户年龄", dataType = "int",paramType = "query")
    })
    @GetMapping("/select")
    public ResultObject<Employee> findAll(@ApiParam(hidden = true) @RequestParam Map<String,Object> map) {
        PageInfo<Employee> pageInfo = this.employeeService.findAll(map);
        if(pageInfo != null){
            log.info("{}", "查询员工信息成功");
            return ResultResponse.success("查询员工成功", pageInfo);
        }
        log.info("{}", "查询员工信息失败");
        return ResultResponse.error("查询员工失败");
    }

    @ApiOperation(value = "查询员工详细信息", httpMethod = "GET", notes = "根据员工ID查询员工详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="员工ID", dataType = "String",paramType = "query")
    })
    @GetMapping("/select/id")
    public ResultObject<Employee> selectById(@ApiParam(hidden = true) @RequestParam String id) {
        Employee employee = this.employeeService.selectById(id);
        if(employee != null){
            log.info("{}", "查询员工信息成功");
            return ResultResponse.success("查询员工成功", employee);
        }
        log.info("{}", "查询员工信息失败");
        return ResultResponse.error("查询员工失败");
    }

}
