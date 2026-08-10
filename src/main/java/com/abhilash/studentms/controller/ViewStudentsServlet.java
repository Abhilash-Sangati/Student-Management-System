package com.abhilash.studentms.controller;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.dao.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {

        int page = 1;
        int pageSize = 5;

        String pageParameter = request.getParameter("page");

        if (pageParameter != null) {
            try {
                page = Integer.parseInt(pageParameter);

                if (page < 1) {
                    page = 1;
                }

            } catch (NumberFormatException e) {
                page = 1;
            }
        }

        StudentDAO dao = new StudentDAOImpl();

        List<com.abhilash.studentms.model.Student> students =
                dao.getStudentsByPage(page, pageSize);

        int totalStudents = dao.getTotalStudentCount();

        int totalPages = (int) Math.ceil((double) totalStudents / pageSize);

        request.setAttribute("studentList", students);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("view-students.jsp").forward(request, response);
    }
}