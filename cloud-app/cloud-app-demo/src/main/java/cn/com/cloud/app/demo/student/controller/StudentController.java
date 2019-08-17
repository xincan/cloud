package cn.com.cloud.app.demo.student.controller;


import cn.com.cloud.app.demo.students.entity.Student;
import cn.com.cloud.app.demo.students.service.StudentService;
import cn.com.cloud.common.data.result.ResultObject;
import cn.com.cloud.common.data.result.ResultResponse;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = {"学生管理"})
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;


    @ApiOperation(value="添加学生信息",httpMethod="POST",notes="根据参数列表添加学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="学号", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="name",value="真实名称",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sex",value="学生性别", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="age",value="学生年龄", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="sclass",value="所在班级", dataType = "String",paramType = "query")

    })
    @PostMapping("/insert")
    public ResultObject<Object> insert(@ApiParam(hidden = true) @RequestParam Map<String,Object> map){
        Student student = JSON.parseObject(JSON.toJSONString(map), Student.class);
        int num = this.studentService.insert(student);
        if(num>0){
            log.info("{}", "添加学生信息成功");
            return ResultResponse.success("添加学生成功",student);
        }
        log.info("{}", "添加学生信息失败");
        return ResultResponse.error("添加学生失败");
    }

    @ApiOperation(value="修改学生信息",httpMethod="POST", notes="根据学生ID，修改参数列表中对应的学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="学号ID", dataType = "String", required = true,paramType = "query"),
            @ApiImplicitParam(name="name",value="真实名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sex",value="学生性别", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="age",value="学生年龄", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="sclass",value="所在班级", dataType = "String",paramType = "query")
    })
    @PostMapping({"/update"})
    public ResultObject<Object> update(@ApiParam(hidden = true) @RequestParam Map<String,Object> map){
        Student student = JSON.parseObject(JSON.toJSONString(map), Student.class);
        int num = this.studentService.update(student);
        if(num>0){
            log.info("{}", "修改成功");
            return ResultResponse.success("修改成功", student);
        }
        log.info("{}", "修改失败");
        return ResultResponse.error("修改失败",student);
    }

    @ApiOperation(value="删除详细信息",httpMethod = "POST", notes="根据学号ID，删除学生详细信息（支持批量删除ID用','英文逗号隔开）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学生ID(多个用英文、号隔开)", required = true, dataType = "String", paramType="query")
    })
    @PostMapping("/delete")
    public ResultObject<Object> delete(@RequestParam  String id) {
        int num = this.studentService.deleteByIds(id);
        if(num > 0){
            log.info("{}", "删除成功");
            return  ResultResponse.success("删除成功", id);
        }
        log.info("{}", "删除失败");
        return ResultResponse.error("删除失败", id);
    }

    @ApiOperation(value = "查询学生信息", httpMethod = "GET", notes = "根据查询条件分页查询学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页数", defaultValue="0", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="size",value="每页条数", defaultValue="10", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="sortName",value="排序字段名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sortOrder",value="排序规则(ASC,DESC)，默认DESC", defaultValue = "DESC",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="startTime",value="开始时间", dataType = "Date",paramType = "query"),
            @ApiImplicitParam(name="endTime",value="结束时间", dataType = "Date",paramType = "query"),

            @ApiImplicitParam(name="id",value="学号ID", dataType = "String", required = true,paramType = "query"),
            @ApiImplicitParam(name="name",value="真实名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sex",value="学生性别", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="age",value="学生年龄", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="sclass",value="所在班级", dataType = "String",paramType = "query")
    })
    @GetMapping("/select")
    public ResultObject<Student> findAll(@ApiParam(hidden = true) @RequestParam Map<String,Object> map) {
        PageInfo<Student> pageInfo = this.studentService.findAll(map);
        if(pageInfo != null){
            log.info("{}", "查询学生信息成功");
            return ResultResponse.success("查询学生成功", pageInfo);
        }
        log.info("{}", "查询学生信息失败");
        return ResultResponse.error("查询学生失败");
    }

    @ApiOperation(value = "查询学生详细信息", httpMethod = "GET", notes = "根据学号ID查询学生详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="学号ID", dataType = "String",paramType = "query")
    })
    @GetMapping("/select/id")
    public ResultObject<Student> selectById(@ApiParam(hidden = true) @RequestParam String id) {
        Student student = this.studentService.selectById(id);
        if(student != null){
            log.info("{}", "查询学生信息成功");
            return ResultResponse.success("查询学生成功", student);
        }
        log.info("{}", "查询学生信息失败");
        return ResultResponse.error("查询学生失败");
    }




}
