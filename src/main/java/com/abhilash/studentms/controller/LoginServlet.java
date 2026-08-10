package com.abhilash.studentms.controller;

import com.abhilash.studentms.dao.AdminDAO;
import com.abhilash.studentms.dao.AdminDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.isBlank()
                || password == null || password.isBlank()) {

            response.sendRedirect("login.jsp?error=empty");
            return;
        }

        AdminDAO adminDAO = new AdminDAOImpl();

        if (adminDAO.validateAdmin(username, password)) {

            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", username);

            response.sendRedirect("dashboard");

        } else {

            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}