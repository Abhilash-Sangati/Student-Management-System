package com.abhilash.studentms.controller;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.dao.StudentDAOImpl;
import com.abhilash.studentms.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/searchStudent")
public class SearchStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        StudentDAO dao = new StudentDAOImpl();

        List<Student> studentList = dao.searchStudents(keyword);

        request.setAttribute("studentList", studentList);

        request.getRequestDispatcher("view-students.jsp")
                .forward(request, response);
    }
}