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

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                         throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        double marks = Double.parseDouble(request.getParameter("marks"));

        Student student = new Student(id, name, email, course, marks);
        StudentDAO dao = new StudentDAOImpl();

        boolean status = dao.addStudent(student);

        if (status) {
            response.sendRedirect("viewStudents?success=added");
        } else {
            response.sendRedirect("add-student.jsp?error=true");
        }
    }
}