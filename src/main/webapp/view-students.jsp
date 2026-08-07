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

            <form action="searchStudent" method="get" class="mb-4">

                <div class="input-group">

                    <input
                            type="text"
                            name="keyword"
                            class="form-control"
                            placeholder="Search by Name, Course or Email">

                    <button class="btn btn-primary" type="submit">
                        Search
                    </button>

                    <a href="viewStudents" class="btn btn-secondary">
                        Reset
                    </a>

                </div>

            </form>

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

            <a href="dashboard" class="btn btn-secondary">

                Back

            </a>

        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>