package com.abhilash.studentms.controller;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.dao.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        StudentDAO dao = new StudentDAOImpl();
        boolean status = dao.deleteStudent(id);

        if (status) {
            response.sendRedirect("viewStudents?success=deleted");
        } else {
            response.sendRedirect("viewStudents?error=delete");
        }
    }
}