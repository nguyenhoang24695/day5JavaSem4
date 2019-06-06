package com.fpt.edu.controller;

import com.fpt.edu.model.StudentCMD;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ListStudentController  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("studentList", StudentCMD.getList());
            req.getRequestDispatcher("/student/list.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
