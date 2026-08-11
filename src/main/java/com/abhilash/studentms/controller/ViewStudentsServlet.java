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
import java.util.List;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
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

        String sortBy = request.getParameter("sortBy");
        String sortOrder = request.getParameter("sortOrder");

        if (sortBy == null || sortBy.isEmpty()) {
            sortBy = "id";
        }

        if (sortOrder == null || sortOrder.isEmpty()) {
            sortOrder = "asc";
        }

        StudentDAO dao = new StudentDAOImpl();

        List<Student> students =
                dao.getStudentsByPageSorted(
                        page,
                        pageSize,
                        sortBy,
                        sortOrder
                );

        int totalStudents = dao.getTotalStudentCount();

        int totalPages =
                (int) Math.ceil((double) totalStudents / pageSize);

        request.setAttribute("studentList", students);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("sortBy", sortBy);
        request.setAttribute("sortOrder", sortOrder);

        request.getRequestDispatcher("view-students.jsp")
                .forward(request, response);
    }
}