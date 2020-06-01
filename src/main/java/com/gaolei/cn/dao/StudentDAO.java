package com.gaolei.cn.dao;

import com.gaolei.cn.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.UUID;

@Repository
public class StudentDAO{
    @Autowired
    DataSource dataSource;

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public boolean createStudent(String name, int age){

        String sql = "INSERT INTO student("+Student.id+","+Student.name+","+Student.age+") VALUES (?,?,?)";
        String id = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(id);
        boolean result = false;
        int updateNum = -1;
        {
            try {
                con = dataSource.getConnection();
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1,id);
                pstmt.setString(2,name);
                pstmt.setInt(3,age);
                updateNum = pstmt.executeUpdate();
                System.out.println(sql);
                System.out.println(updateNum);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    getClose();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return updateNum>0?true:result;

    }

    public void  getClose() throws SQLException{
        if(rs!=null)
            rs.close();
        if(pstmt !=null)
            pstmt.close();
        if(con!=null)
            con.close();
    }


}
