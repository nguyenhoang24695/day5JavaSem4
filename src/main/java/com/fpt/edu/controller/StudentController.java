package com.fpt.edu.controller;
import com.fpt.edu.entity.Student;
import com.fpt.edu.model.SecurityHandle;
import com.fpt.edu.model.StudentCMD;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class StudentController  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/student/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String rollNumber =  req.getParameter("rollNumber");
        String fullName =  req.getParameter("fullName");
        String phone =  req.getParameter("phone");
        String email =  req.getParameter("email");

        String password =  req.getParameter("password");
        try {

            String salt = Base64.getEncoder().encodeToString(SecurityHandle.getSalt());
            String hashPassword = SecurityHandle.getSecurePassword(password,salt.getBytes());
            Student std = new Student(rollNumber,fullName,email,phone,hashPassword,salt,1);
            System.out.println(std);
            if(StudentCMD.saveStudent(std)){
                resp.sendRedirect("/student/list");
            }else{
                resp.sendRedirect("/student/register");
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("err");
            e.printStackTrace();
        }

    }
}