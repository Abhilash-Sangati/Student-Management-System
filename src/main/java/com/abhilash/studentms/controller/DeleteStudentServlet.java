package com.abhilash.studentms.controller;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.dao.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");

        if (idParameter == null || idParameter.isBlank()) {
            response.sendRedirect("viewStudents?error=invalidId");
            return;
        }

        int id;

        try {
            id = Integer.parseInt(idParameter);

            if (id <= 0) {
                response.sendRedirect("viewStudents?error=invalidId");
                return;
            }

        } catch (NumberFormatException e) {
            response.sendRedirect("viewStudents?error=invalidId");
            return;
        }

        StudentDAO dao = new StudentDAOImpl();
        boolean status = dao.deleteStudent(id);

        if (status) {
            response.sendRedirect("viewStudents?success=deleted");
        } else {
            response.sendRedirect("viewStudents?error=delete");
        }
    }
}