//package com.gaolei.cn.dao.impl;
//
//import com.gaolei.cn.dao.GradeMapper;
//import com.gaolei.cn.entities.Grade;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.io.IOException;
//import java.util.List;
//
//@Repository
//public class GradeMapperImpl implements GradeMapper {
//    @Autowired
//    SqlSessionFactory sqlSessionFactory;
//
//    @Autowired
//    private SqlSession sqlSession;
//
//    @Override
//    public List<Grade> getAll() {
//        return null;
//    }
//
//    @Override
//    public Grade getOne(Long id) {
//        return null;
//    }
//
//    @Override
//    public void insert(Grade grade) {
//        try{
//            sqlSession = sqlSessionFactory.openSession();
//            sqlSession.insert("insert",grade);
//            sqlSession.commit();
//        } finally {
//            sqlSession.close();
//        }
//
//    }
//
//    @Override
//    public void update(Grade user) {
//
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//}
