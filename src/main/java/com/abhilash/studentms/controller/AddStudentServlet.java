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

        String idParameter = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String marksParameter = request.getParameter("marks");

        // Validate empty fields
        if (idParameter == null || idParameter.isBlank()
                || name == null || name.isBlank()
                || email == null || email.isBlank()
                || course == null || course.isBlank()
                || marksParameter == null || marksParameter.isBlank()) {

            response.sendRedirect("add-student.jsp?error=empty");
            return;
        }

        int id;
        double marks;

        // Validate ID
        try {
            id = Integer.parseInt(idParameter);
            if (id <= 0) {
                response.sendRedirect("add-student.jsp?error=id");
                return;
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("add-student.jsp?error=id");
            return;
        }

        // Validate marks
        try {
            marks = Double.parseDouble(marksParameter);

            if (marks < 0 || marks > 100) {
                response.sendRedirect("add-student.jsp?error=marks");
                return;
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("add-student.jsp?error=marks");
            return;
        }

        // Validate email
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            response.sendRedirect("add-student.jsp?error=email");
            return;
        }

        Student student = new Student(id, name, email, course, marks);

        StudentDAO dao = new StudentDAOImpl();

        boolean status = dao.addStudent(student);

        if (status) {
            response.sendRedirect("viewStudents?success=added");
        } else {
            response.sendRedirect("add-student.jsp?error=database");
        }
    }
}