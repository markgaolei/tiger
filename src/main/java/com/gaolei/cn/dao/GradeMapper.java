package com.gaolei.cn.dao;

import com.gaolei.cn.entities.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {
    List<Grade> getAll();

    Grade getOne(Long id);

    void insert(Grade grade);

    void update(Grade grade);

    void delete(Long id);
}
