package com.abhilash.studentms.controller;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.dao.StudentDAOImpl;
import com.abhilash.studentms.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/studentDetails")
public class StudentDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");

        if (idParameter == null || idParameter.isEmpty()) {
            response.sendRedirect("viewStudents");
            return;
        }

        try {
            int id = Integer.parseInt(idParameter);

            StudentDAO dao = new StudentDAOImpl();
            Student student = dao.getStudentById(id);

            if (student == null) {
                response.sendRedirect("viewStudents?error=notFound");
                return;
            }

            request.setAttribute("student", student);

            request.getRequestDispatcher("student-details.jsp")
                    .forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect("viewStudents?error=invalidId");
        }
    }
}