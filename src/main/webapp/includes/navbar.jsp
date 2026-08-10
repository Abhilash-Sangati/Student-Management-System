<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">

        <a class="navbar-brand" href="dashboard">
            Student Management System
        </a>

        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">

            <ul class="navbar-nav ms-auto">

                <li class="nav-item">
                    <a class="nav-link" href="dashboard">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="add-student.jsp">Add Student</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="viewStudents">View Students</a>
                </li>

                <!-- NEW: Pagination -->
                <li class="nav-item">
                    <a class="nav-link" href="students">Students (Pages)</a>
                </li>

                <li class="nav-item">
                    <span class="nav-link text-info">
                        Welcome, <%= session.getAttribute("loggedInUser") %>
                    </span>
                </li>

                <li class="nav-item">
                    <a class="nav-link text-danger"
                       href="logout"
                       onclick="return confirm('Are you sure you want to logout?')">
                        Logout
                    </a>
                </li>

            </ul>

        </div>
    </div>
</nav>