<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow">

                <div class="card-header bg-dark text-white text-center">
                    <h3>Student Management System</h3>
                    <p class="mb-0">Admin Login</p>
                </div>

                <div class="card-body">

                    <% if ("empty".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-warning">
                        Please enter username and password.
                    </div>
                    <% } %>

                    <% if ("invalid".equals(request.getParameter("error"))) { %>
                    <div class="alert alert-danger">
                        Invalid username or password.
                    </div>
                    <% } %>

                    <form action="login" method="post">

                        <div class="mb-3">
                            <label class="form-label">Username</label>
                            <input type="text" name="username"
                                   class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input type="password" name="password"
                                   class="form-control" required>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">
                            Login
                        </button>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>