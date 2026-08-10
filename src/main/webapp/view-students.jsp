<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.abhilash.studentms.model.Student" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<jsp:include page="includes/navbar.jsp"/>

<div class="container mt-5">
    <div class="card shadow">

        <div class="card-header bg-primary text-white">
            <h3>Student List</h3>
        </div>

        <div class="card-body">

            <% if ("added".equals(request.getParameter("success"))) { %>
            <div class="alert alert-success">Student added successfully!</div>
            <% } %>

            <% if ("updated".equals(request.getParameter("success"))) { %>
            <div class="alert alert-success">Student updated successfully!</div>
            <% } %>

            <% if ("deleted".equals(request.getParameter("success"))) { %>
            <div class="alert alert-success">Student deleted successfully!</div>
            <% } %>

            <% if ("delete".equals(request.getParameter("error"))) { %>
            <div class="alert alert-danger">Failed to delete student.</div>
            <% } %>

            <% if ("invalidId".equals(request.getParameter("error"))) { %>
            <div class="alert alert-danger">Invalid student ID.</div>
            <% } %>

            <%
                String keyword = (String) request.getAttribute("keyword");
                if (keyword == null) {
                    keyword = "";
                }

                Integer currentPage =
                        (Integer) request.getAttribute("currentPage");

                Integer totalPages =
                        (Integer) request.getAttribute("totalPages");

                if (currentPage == null) {
                    currentPage = 1;
                }

                if (totalPages == null) {
                    totalPages = 1;
                }
            %>

            <!-- Search -->

            <form action="searchStudent" method="get" class="mb-4">

                <div class="input-group">

                    <input type="text"
                           name="keyword"
                           class="form-control"
                           placeholder="Search by ID, Name, Course or Email"
                           value="<%= keyword %>">

                    <button class="btn btn-primary" type="submit">
                        Search
                    </button>

                    <a href="viewStudents" class="btn btn-secondary">
                        Reset
                    </a>

                </div>

            </form>

            <!-- Student Table -->

            <table class="table table-bordered table-hover">

                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Course</th>
                    <th>Marks</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>

                <tbody>

                <%
                    List<Student> studentList =
                            (List<Student>) request.getAttribute("studentList");

                    if (studentList != null && !studentList.isEmpty()) {

                        for (Student student : studentList) {
                %>

                <tr>
                    <td><%= student.getId() %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.getEmail() %></td>
                    <td><%= student.getCourse() %></td>
                    <td><%= student.getMarks() %></td>

                    <td>
                        <a href="editStudent?id=<%= student.getId() %>"
                           class="btn btn-warning btn-sm">
                            Edit
                        </a>
                    </td>

                    <td>
                        <a href="deleteStudent?id=<%= student.getId() %>"
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this student?')">
                            Delete
                        </a>
                    </td>
                </tr>

                <%
                    }

                } else {
                %>

                <tr>
                    <td colspan="7" class="text-center text-danger">
                        No Students Found
                    </td>
                </tr>

                <%
                    }
                %>

                </tbody>
            </table>

            <!-- Pagination -->

            <% if (totalPages > 1) { %>

            <nav>
                <ul class="pagination justify-content-center">

                    <% if (currentPage > 1) { %>

                    <li class="page-item">

                        <% if (!keyword.isEmpty()) { %>

                        <a class="page-link"
                           href="searchStudent?keyword=<%= keyword %>&page=<%= currentPage - 1 %>">
                            Previous
                        </a>

                        <% } else { %>

                        <a class="page-link"
                           href="viewStudents?page=<%= currentPage - 1 %>">
                            Previous
                        </a>

                        <% } %>

                    </li>

                    <% } %>


                    <% for (int i = 1; i <= totalPages; i++) { %>

                    <li class="page-item <%= i == currentPage ? "active" : "" %>">

                        <% if (!keyword.isEmpty()) { %>

                        <a class="page-link"
                           href="searchStudent?keyword=<%= keyword %>&page=<%= i %>">
                            <%= i %>
                        </a>

                        <% } else { %>

                        <a class="page-link"
                           href="viewStudents?page=<%= i %>">
                            <%= i %>
                        </a>

                        <% } %>

                    </li>

                    <% } %>


                    <% if (currentPage < totalPages) { %>

                    <li class="page-item">

                        <% if (!keyword.isEmpty()) { %>

                        <a class="page-link"
                           href="searchStudent?keyword=<%= keyword %>&page=<%= currentPage + 1 %>">
                            Next
                        </a>

                        <% } else { %>

                        <a class="page-link"
                           href="viewStudents?page=<%= currentPage + 1 %>">
                            Next
                        </a>

                        <% } %>

                    </li>

                    <% } %>

                </ul>
            </nav>

            <% } %>

            <a href="dashboard" class="btn btn-secondary">
                Back
            </a>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>