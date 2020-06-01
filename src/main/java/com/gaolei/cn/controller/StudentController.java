package com.gaolei.cn.controller;

import com.gaolei.cn.dao.GradeMapper;
import com.gaolei.cn.dao.StudentDAO;
import com.gaolei.cn.entities.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentDAO studentDAO;

    @Resource
    GradeMapper gradeMapper;

    @GetMapping("/create")
    public String createStudent(@RequestParam(value = "name") String name, @RequestParam (value = "age") Integer age ){
        boolean result = studentDAO.createStudent(name,age);
        return result== true?"ok":"not ok";
    }

    @GetMapping("/insert")
    public void createStudent(){
        String id = UUID.randomUUID().toString().replaceAll("-","");
        Grade grade = new Grade();
        grade.setId(id);
        grade.setScore(99.23);
        grade.setStu_num(102);
        gradeMapper.insert(grade);

    }

}
