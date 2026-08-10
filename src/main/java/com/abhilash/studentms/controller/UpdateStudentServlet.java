package com.abhilash.studentms.controller;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.dao.StudentDAOImpl;
import com.abhilash.studentms.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String marksParameter = request.getParameter("marks");

        if (idParameter == null || idParameter.isBlank()
                || name == null || name.isBlank()
                || email == null || email.isBlank()
                || course == null || course.isBlank()
                || marksParameter == null || marksParameter.isBlank()) {

            response.sendRedirect("editStudent?id=" + idParameter + "&error=empty");
            return;
        }

        int id;
        double marks;

        try {
            id = Integer.parseInt(idParameter);

            if (id <= 0) {
                response.sendRedirect("editStudent?id=" + idParameter + "&error=id");
                return;
            }

        } catch (NumberFormatException e) {
            response.sendRedirect("editStudent?id=" + idParameter + "&error=id");
            return;
        }

        try {
            marks = Double.parseDouble(marksParameter);

            if (marks < 0 || marks > 100) {
                response.sendRedirect("editStudent?id=" + id + "&error=marks");
                return;
            }

        } catch (NumberFormatException e) {
            response.sendRedirect("editStudent?id=" + idParameter + "&error=marks");
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            response.sendRedirect("editStudent?id=" + id + "&error=email");
            return;
        }

        Student student = new Student(id, name, email, course, marks);

        StudentDAO dao = new StudentDAOImpl();
        boolean status = dao.updateStudent(student);

        if (status) {
            response.sendRedirect("viewStudents?success=updated");
        } else {
            response.sendRedirect("editStudent?id=" + id + "&error=database");
        }
    }
}