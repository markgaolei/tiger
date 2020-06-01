package com.gaolei.cn.controller;

import com.gaolei.cn.dao.GradeMapper;
import com.gaolei.cn.entities.Grade;
import com.gaolei.cn.util.serialize.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/grade")
public class GradeController {

    private Long expireTime = 1800L;
    @Resource
    private GradeMapper gradeMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/getall")
    public String getAll(){

        List<Grade> gradeList = gradeMapper.getAll();
        if (gradeList!=null && gradeList.size()>=0){
            for (Grade grade: gradeList) {
                redisTemplate.opsForValue().set(grade.getId(), grade,expireTime, TimeUnit.SECONDS);
                System.out.println("ID:" + grade.getId());
                System.out.println("学生数据：" + grade.getId() + grade.getStu_num());
            }
        }
        Grade firstGrade = (Grade)redisTemplate.opsForValue().get(gradeList.get(0).getId());
        System.out.println(firstGrade.getId() + firstGrade.getScore() + firstGrade.getStu_num());
        return firstGrade==null?"no key":"ok";
    }
}
