package com.fpt.edu.model;

import com.fpt.edu.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentCMD {
    public static boolean saveStudent(Student student) {
        try {
            String sql = "insert into students(rollNumber,fullName,email,phone,password,salt,status) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = ConnectionHelper.getInstance().ConnectionHelper().prepareStatement(sql);
            ps.setString(1,student.getRollNumber());
            ps.setString(2,student.getFullName());
            ps.setString(3,student.getEmail());
            ps.setString(4,student.getPhone());
            ps.setString(5,student.getPassword());
            ps.setString(6,student.getSalt());
            ps.setInt(7,student.getStatus());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static ArrayList<Student> getList() throws SQLException {
        ArrayList<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM students";
        PreparedStatement ps = ConnectionHelper.getInstance().ConnectionHelper().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String rollNumber = rs.getString("rollNumber");
            String name = rs.getString("fullName");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            int status = rs.getInt("status");
            Student studentGetList = new Student(rollNumber,name,email,phone,null,null,status);
            studentList.add(studentGetList);
        }
        return studentList;
    }
}
