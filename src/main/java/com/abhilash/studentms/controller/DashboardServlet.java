package com.abhilash.studentms.controller;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.dao.StudentDAOImpl;
import com.abhilash.studentms.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        StudentDAO dao = new StudentDAOImpl();

        List<Student> students = dao.getAllStudents();

        int total = students.size();

        double highest = 0;

        double sum = 0;

        for (Student student : students) {

            sum += student.getMarks();

            if (student.getMarks() > highest) {
                highest = student.getMarks();
            }
        }

        double average = total == 0 ? 0 : sum / total;

        request.setAttribute("total", total);
        request.setAttribute("highest", highest);
        request.setAttribute("average", average);

        request.getRequestDispatcher("index.jsp")
                .forward(request, response);
    }
}