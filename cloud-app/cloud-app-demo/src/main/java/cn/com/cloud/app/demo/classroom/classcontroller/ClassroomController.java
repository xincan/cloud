package cn.com.cloud.app.demo.classroom.classcontroller;


import cn.com.cloud.app.demo.student.service.StudentService;
import cn.com.cloud.app.demo.teacher.entity.Teacher;
import cn.com.cloud.app.demo.teacher.service.TeacherService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"班级年级管理"})
@RestController
@RequestMapping("/class")
@Slf4j
public class ClassroomController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;




}
