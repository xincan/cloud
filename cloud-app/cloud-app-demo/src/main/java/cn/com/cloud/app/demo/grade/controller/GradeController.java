package cn.com.cloud.app.demo.grade.controller;

import cn.com.cloud.app.demo.grade.entity.Grade;
import cn.com.cloud.app.demo.grade.service.GradeService;
import cn.com.cloud.app.demo.student.entity.Student;
import cn.com.cloud.app.demo.student.service.StudentService;
import cn.com.cloud.app.demo.teacher.entity.Teacher;
import cn.com.cloud.app.demo.teacher.service.TeacherService;
import cn.com.cloud.common.data.result.ResultObject;
import cn.com.cloud.common.data.result.ResultResponse;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = {"年级管理"})
@RestController
@RequestMapping("/grade")
@Slf4j
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;


    /**
     * 获取部门树形列表
     */

    @ApiOperation(value = "获取部门树形列表", httpMethod = "GET")

    @GetMapping("/getTree")
    public List<Grade> getTree(){
        List<Grade> root = gradeService.findBypid("0");  //获取根节点（获取的值存到list中）
        return buildTree(root);
    }
    public List<Grade> buildTree(List<Grade> root){
        for(int i=0;i<root.size();i++){
            List<Grade> children = gradeService.findBypid(root.get(i).getId()); //查询某节点的子节点（获取的是list）
            buildTree(children);
            root.get(i).setChildren(children);
        }
        return root;
    }
  @ApiOperation(value = "查询学生信息", httpMethod = "GET", notes = "根据查询条件分页查询学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页数", defaultValue="0", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="size",value="每页条数", defaultValue="10", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="sortName",value="排序字段名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sortOrder",value="排序规则(ASC,DESC)，默认DESC", defaultValue = "DESC",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="startTime",value="开始时间", dataType = "Date",paramType = "query"),
            @ApiImplicitParam(name="endTime",value="结束时间", dataType = "Date",paramType = "query"),


            @ApiImplicitParam(name="sclass",value="所在班级", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="grade",value="所在年级", dataType = "String",paramType = "query")
    })
    @GetMapping("/selectstudent")
    public ResultObject<Student> findSAll(@ApiParam(hidden = true) @RequestParam Map<String,Object> map) {
        PageInfo<Student> pageInfo = this.studentService.findAll(map);
        if(pageInfo != null){
            log.info("{}", "查询学生信息成功");
            return ResultResponse.success("查询学生成功", pageInfo);
        }
        log.info("{}", "查询学生信息失败");
        return ResultResponse.error("查询学生失败");
    }
      @ApiOperation(value = "查询老师信息", httpMethod = "GET", notes = "根据查询条件分页查询老师信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页数", defaultValue="0", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="size",value="每页条数", defaultValue="10", dataType = "int",paramType = "query"),
            @ApiImplicitParam(name="sortName",value="排序字段名称", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="sortOrder",value="排序规则(ASC,DESC)，默认DESC", defaultValue = "DESC",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="startTime",value="开始时间", dataType = "Date",paramType = "query"),
            @ApiImplicitParam(name="endTime",value="结束时间", dataType = "Date",paramType = "query"),

            @ApiImplicitParam(name="tclass",value="所带班级", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="grade",value="所在年级", dataType = "String",paramType = "query")
    })
    @GetMapping("/selectteacher")
    public ResultObject<Teacher> findTAll(@ApiParam(hidden = true) @RequestParam Map<String,Object> map) {
        PageInfo<Teacher> pageInfo = this.teacherService.findAll(map);
        if(pageInfo != null){
            log.info("{}", "查询老师信息成功");
            return ResultResponse.success("查询老师成功", pageInfo);
        }
        log.info("{}", "查询老师信息失败");
        return ResultResponse.error("查询老师失败");
    }
}
