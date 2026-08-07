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

    <div class="card shadow">

        <div class="card-header bg-success text-white">
            <h3>Add Student</h3>
        </div>

        <div class="card-body">

            <form action="addStudent" method="post">

                <div class="mb-3">
                    <label>ID</label>
                    <input class="form-control" type="number" name="id" required>
                </div>

                <div class="mb-3">
                    <label>Name</label>
                    <input class="form-control" type="text" name="name" required>
                </div>

                <div class="mb-3">
                    <label>Email</label>
                    <input class="form-control" type="email" name="email" required>
                </div>

                <div class="mb-3">
                    <label>Course</label>
                    <input class="form-control" type="text" name="course" required>
                </div>

                <div class="mb-3">
                    <label>Marks</label>
                    <input class="form-control" type="number" step="0.01" name="marks" required>
                </div>

                <button class="btn btn-success">
                    Save Student
                </button>

                <a href="index.jsp" class="btn btn-secondary">
                    Back
                </a>

            </form>

        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>