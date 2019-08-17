package cn.com.cloud.app.demo.teacher.controller;



import cn.com.cloud.app.demo.teacher.entity.Teacher;
import cn.com.cloud.app.demo.teacher.service.TeacherService;
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
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   cailei
 * Date:     2019-08-12 16:58:00
 * Description: 老师管理控制层
 */
@Api(tags = {"老师管理"})
@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {
    /**
     * @Author Cailei
     * @Version  1.0
     * @Description 注入老师业务接口
     * @Date 2019-8-13 8:10
     */
    @Autowired
    private TeacherService teacherService;


    @ApiOperation(value="添加老师信息",httpMethod="POST",notes="根据参数列表添加老师信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="老师ID", dataType = "String", required = true,paramType = "query"),
            @ApiImplicitParam(name="name",value="真实名称",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sex",value="用户性别", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="age",value="用户年龄", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="tclass",value="所带班级", dataType = "String",paramType = "query")
    })
    @PostMapping("/insert")
    public ResultObject<Object> insert(@ApiParam(hidden = true) @RequestParam Map<String,Object> map){
        Teacher teacher = JSON.parseObject(JSON.toJSONString(map), Teacher.class);
        int num = this.teacherService.insert(teacher);
        if(num>0){
            log.info("{}", "添加老师信息成功");
            return ResultResponse.success("添加老师成功",teacher);
        }
        log.info("{}", "添加老师信息失败");
        return ResultResponse.error("添加老师失败");
    }

    @ApiOperation(value="修老师信息",httpMethod="POST", notes="根据老师ID，修改参数列表中对应的老师信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="老师ID", dataType = "String", required = true,paramType = "query"),
            @ApiImplicitParam(name="name",value="真实名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sex",value="用户性别", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="age",value="用户年龄", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="tclass",value="所带班级", dataType = "String",paramType = "query")
    })
    @PostMapping({"/update"})
    public ResultObject<Object> update(@ApiParam(hidden = true) @RequestParam Map<String,Object> map){
        Teacher teacher = JSON.parseObject(JSON.toJSONString(map), Teacher.class);
        int num = this.teacherService.update(teacher);
        if(num>0){
            log.info("{}", "修改老师信息成功");
            return ResultResponse.success("修改老师信息成功", teacher);
        }
        log.info("{}", "修改老师信息失败");
        return ResultResponse.error("修改老师信息失败",teacher);
    }

    @ApiOperation(value="删除老师详细信息",httpMethod = "POST", notes="根据用户ID，删除老师详细信息（支持批量删除ID用','英文逗号隔开）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "老师ID(多个用英文、号隔开)", required = true, dataType = "String", paramType="query")
    })
    @PostMapping("/delete")
    public ResultObject<Object> delete(@RequestParam  String id) {
        int num = this.teacherService.deleteByIds(id);
        if(num > 0){
            log.info("{}", "删除老师成功");
            return  ResultResponse.success("删除老师成功", id);
        }
        log.info("{}", "删除老师失败");
        return ResultResponse.error("删除老师失败", id);
    }

    @ApiOperation(value = "查询老师信息", httpMethod = "GET", notes = "根据查询条件分页查询老师信息")
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
            @ApiImplicitParam(name="age",value="用户年龄", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="tclass",value="所带班级", dataType = "String",paramType = "query")
    })
    @GetMapping("/select")
    public ResultObject<Teacher> findAll(@ApiParam(hidden = true) @RequestParam Map<String,Object> map) {
        PageInfo<Teacher> pageInfo = this.teacherService.findAll(map);
        if(pageInfo != null){
            log.info("{}", "查询老师信息成功");
            return ResultResponse.success("查询老师成功", pageInfo);
        }
        log.info("{}", "查询老师信息失败");
        return ResultResponse.error("查询老师失败");
    }

    @ApiOperation(value = "查询老师详细信息", httpMethod = "GET", notes = "根据员工ID查询老师详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="老师ID", dataType = "String",paramType = "query")
    })
    @GetMapping("/select/id")
    public ResultObject<Teacher> selectById(@ApiParam(hidden = true) @RequestParam String id) {
        Teacher teacher = this.teacherService.selectById(id);
        if(teacher != null){
            log.info("{}", "查询老师信息成功");
            return ResultResponse.success("查询老师成功", teacher);
        }
        log.info("{}", "查询老师信息失败");
        return ResultResponse.error("查询老师失败");
    }

}


