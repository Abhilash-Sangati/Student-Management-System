<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Student Management System</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<jsp:include page="includes/navbar.jsp"/>

<div class="container mt-5">

    <div class="row text-center">

        <div class="col-md-4 mb-3">

            <div class="card border-primary shadow">

                <div class="card-body">

                    <h5>Total Students</h5>

                    <h2>${total}</h2>

                </div>

            </div>

        </div>

        <div class="col-md-4 mb-3">

            <div class="card border-success shadow">

                <div class="card-body">

                    <h5>Highest Marks</h5>

                    <h2>${highest}</h2>

                </div>

            </div>

        </div>

        <div class="col-md-4 mb-3">

            <div class="card border-warning shadow">

                <div class="card-body">

                    <h5>Average Marks</h5>

                    <h2>${average}</h2>

                </div>

            </div>

        </div>

    </div>

    <hr>

    <div class="text-center">

        <a href="add-student.jsp" class="btn btn-success btn-lg me-3">
            Add Student
        </a>

        <a href="viewStudents" class="btn btn-primary btn-lg">
            View Students
        </a>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>