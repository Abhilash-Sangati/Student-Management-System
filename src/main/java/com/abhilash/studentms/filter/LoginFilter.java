package com.abhilash.studentms.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        String requestURI = httpRequest.getRequestURI();
        String contextPath = httpRequest.getContextPath();

        boolean loggedIn = session != null &&
                session.getAttribute("loggedInUser") != null;

        boolean loginRequest =
                requestURI.equals(contextPath + "/login") ||
                        requestURI.equals(contextPath + "/login.jsp");

        boolean staticResource =
                requestURI.endsWith(".css") ||
                        requestURI.endsWith(".js") ||
                        requestURI.endsWith(".png") ||
                        requestURI.endsWith(".jpg") ||
                        requestURI.endsWith(".jpeg");

        // Prevent browser from caching protected pages
        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpResponse.setHeader("Pragma", "no-cache");
        httpResponse.setDateHeader("Expires", 0);

        if (loggedIn || loginRequest || staticResource) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(contextPath + "/login.jsp");
        }
    }
}