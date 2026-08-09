<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<jsp:include page="includes/navbar.jsp"/>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-7">
            <div class="card shadow">
                <div class="card-header bg-success text-white">
                    <h3>Add Student</h3>
                </div>

                <div class="card-body">

                    <% if ("empty".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger">Please fill in all fields.</div>
                    <% } %>

                    <% if ("id".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger">ID must be a positive number.</div>
                    <% } %>

                    <% if ("marks".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger">Marks must be between 0 and 100.</div>
                    <% } %>

                    <% if ("email".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger">Please enter a valid email address.</div>
                    <% } %>

                    <% if ("database".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger">Unable to add student. ID or email may already exist.</div>
                    <% } %>

                    <form action="addStudent" method="post">

                        <div class="mb-3">
                            <label class="form-label">ID</label>
                            <input type="number" name="id" class="form-control" min="1" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input type="text" name="name" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" name="email" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Course</label>
                            <input type="text" name="course" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Marks</label>
                            <input type="number" name="marks" class="form-control" min="0" max="100" step="0.01" required>
                        </div>

                        <button type="submit" class="btn btn-success">Add Student</button>
                        <a href="dashboard" class="btn btn-secondary">Cancel</a>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>