<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.abhilash.studentms.model.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<jsp:include page="includes/navbar.jsp"/>

<div class="container mt-5">

    <div class="card shadow mx-auto"
         style="max-width: 700px;">

        <div class="card-header bg-primary text-white">
            <h3 class="mb-0">Student Details</h3>
        </div>

        <div class="card-body">

            <div class="row mb-3">

                <div class="col-sm-4 fw-bold">
                    Student ID
                </div>

                <div class="col-sm-8">
                    <%= student.getId() %>
                </div>

            </div>

            <hr>

            <div class="row mb-3">

                <div class="col-sm-4 fw-bold">
                    Name
                </div>

                <div class="col-sm-8">
                    <%= student.getName() %>
                </div>

            </div>

            <hr>

            <div class="row mb-3">

                <div class="col-sm-4 fw-bold">
                    Email
                </div>

                <div class="col-sm-8">
                    <%= student.getEmail() %>
                </div>

            </div>

            <hr>

            <div class="row mb-3">

                <div class="col-sm-4 fw-bold">
                    Course
                </div>

                <div class="col-sm-8">
                    <%= student.getCourse() %>
                </div>

            </div>

            <hr>

            <div class="row mb-3">

                <div class="col-sm-4 fw-bold">
                    Marks
                </div>

                <div class="col-sm-8">
                    <%= student.getMarks() %>
                </div>

            </div>

            <div class="mt-4">

                <a href="viewStudents"
                   class="btn btn-secondary">
                    Back
                </a>

                <a href="editStudent?id=<%= student.getId() %>"
                   class="btn btn-warning">
                    Edit Student
                </a>

            </div>

        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js">
</script>

</body>
</html>