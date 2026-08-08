package com.abhilash.studentms.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                        throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        String requestURI = httpRequest.getRequestURI();

        String contextPath = httpRequest.getContextPath();

        boolean loggedIn = session != null && session.getAttribute("loggedInUser") != null;

        boolean loginRequest = requestURI.equals(contextPath + "/login") || requestURI.equals(contextPath + "/login.jsp");

        boolean staticResource = requestURI.endsWith(".css") || requestURI.endsWith(".js") || requestURI.endsWith(".png") ||
                                 requestURI.endsWith(".jpg") || requestURI.endsWith(".jpeg");

        if (loggedIn || loginRequest || staticResource) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(contextPath + "/login.jsp");
        }
    }
}