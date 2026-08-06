<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.abhilash.studentms.model.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Edit Student</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-warning">
            <h3>Edit Student</h3>
        </div>

        <div class="card-body">

            <form action="updateStudent" method="post">

                <div class="mb-3">

                    <label>ID</label>

                    <input class="form-control"
                           type="number"
                           name="id"
                           value="<%= student.getId() %>"
                           readonly>

                </div>

                <div class="mb-3">

                    <label>Name</label>

                    <input class="form-control"
                           type="text"
                           name="name"
                           value="<%= student.getName() %>"
                           required>

                </div>

                <div class="mb-3">

                    <label>Email</label>

                    <input class="form-control"
                           type="email"
                           name="email"
                           value="<%= student.getEmail() %>"
                           required>

                </div>

                <div class="mb-3">

                    <label>Course</label>

                    <input class="form-control"
                           type="text"
                           name="course"
                           value="<%= student.getCourse() %>"
                           required>

                </div>

                <div class="mb-3">

                    <label>Marks</label>

                    <input class="form-control"
                           type="number"
                           step="0.01"
                           name="marks"
                           value="<%= student.getMarks() %>"
                           required>

                </div>

                <button class="btn btn-warning">
                    Update Student
                </button>

                <a href="viewStudents" class="btn btn-secondary">
                    Cancel
                </a>

            </form>

        </div>

    </div>

</div>

</body>
</html>