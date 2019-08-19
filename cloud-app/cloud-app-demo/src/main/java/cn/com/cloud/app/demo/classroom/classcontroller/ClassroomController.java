package cn.com.cloud.app.demo.classroom.classcontroller;


import cn.com.cloud.app.demo.classroom.entity.Classroom;
import cn.com.cloud.app.demo.classroom.service.ClassroomService;
import cn.com.cloud.app.demo.student.service.StudentService;
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

@Api(tags = {"班级管理"})
@RestController
@RequestMapping("/class")
@Slf4j
public class ClassroomController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;
    @ApiOperation(value="添加班级信息",httpMethod="POST",notes="根据参数列表添加班级信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="班级号码", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="classname",value="班级名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="grade",value="所在年级", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "population",value = "班级人数",dataType = "int",paramType = "query")
    })
    @PostMapping("/insert")
    public ResultObject<Object> insert(@ApiParam(hidden = true) @RequestParam Map<String,Object> map){
        Classroom classroom = JSON.parseObject(JSON.toJSONString(map), Classroom.class);
        int num = this.classroomService.insert(classroom);
        if(num>0){
            log.info("{}", "添加班级信息成功");
            return ResultResponse.success("添加班级成功",classroom);
        }
        log.info("{}", "添加班级信息失败");
        return ResultResponse.error("添加班级失败");
    }

    @ApiOperation(value="修改班级信息",httpMethod="POST", notes="根据班级ID，修改参数列表中对应的班级信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="班级号码", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="classname",value="班级名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="grade",value="所在年级", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "population",value = "班级人数",dataType = "int",paramType = "query")
    })
    @PostMapping({"/update"})
    public ResultObject<Object> update(@ApiParam(hidden = true) @RequestParam Map<String,Object> map){
        Classroom classroom = JSON.parseObject(JSON.toJSONString(map), Classroom.class);
        int num = this.classroomService.insert(classroom);
        if(num>0){
            log.info("{}", "修改班级成功");
            return ResultResponse.success("修改班级成功", classroom);
        }
        log.info("{}", "修改班级失败");
        return ResultResponse.error("修改班级失败",classroom);
    }

    @ApiOperation(value="删除班级详细信息",httpMethod = "POST", notes="根据班级ID，删除班级详细信息（支持批量删除ID用','英文逗号隔开）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "班级ID(多个用英文、号隔开)", required = true, dataType = "String", paramType="query")
    })
    @PostMapping("/delete")
    public ResultObject<Object> delete(@RequestParam  String id) {
        int num = this.classroomService.deleteByIds(id);
        if(num > 0){
            log.info("{}", "删除班级成功");
            return  ResultResponse.success("删除班级成功", id);
        }
        log.info("{}", "删除班级失败");
        return ResultResponse.error("删除班级失败", id);
    }

    @ApiOperation(value = "查询班级信息", httpMethod = "GET", notes = "根据查询条件分页查询员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页数", defaultValue="0", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="size",value="每页条数", defaultValue="10", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="sortName",value="排序字段名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sortOrder",value="排序规则(ASC,DESC)，默认DESC", defaultValue = "DESC",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="startTime",value="开始时间", dataType = "Date",paramType = "query"),
            @ApiImplicitParam(name="endTime",value="结束时间", dataType = "Date",paramType = "query"),

            @ApiImplicitParam(name="id",value="班级号码", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="classname",value="班级名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="grade",value="所在年级", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name ="population",value = "班级人数",dataType = "int",paramType = "query")
    })
    @GetMapping("/select")
    public ResultObject<Classroom> findAll(@ApiParam(hidden = true) @RequestParam Map<String,Object> map) {
        PageInfo<Classroom> pageInfo = this.classroomService.findAll(map);
        if(pageInfo != null){
            log.info("{}", "查询班级信息成功");
            return ResultResponse.success("查询班级成功", pageInfo);
        }
        log.info("{}", "查询班级信息失败");
        return ResultResponse.error("查询班级失败");
    }

    @ApiOperation(value = "查询班级详细信息", httpMethod = "GET", notes = "根据班级ID查询班级详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="员工ID", dataType = "String",paramType = "query")
    })
    @GetMapping("/select/id")
    public ResultObject<Classroom> selectById(@ApiParam(hidden = true) @RequestParam String id) {
        Classroom classroom = this.classroomService.selectById(id);
        if(classroom != null){
            log.info("{}", "查询班级信息成功");
            return ResultResponse.success("查询班级成功", classroom);
        }
        log.info("{}", "查询班级信息失败");
        return ResultResponse.error("查询班级失败");
    }




}
