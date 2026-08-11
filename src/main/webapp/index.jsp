<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management System</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<jsp:include page="includes/navbar.jsp"/>

<div class="container mt-5">

    <div class="text-center mb-4">

        <h2>Dashboard</h2>

        <p class="text-muted">
            Student Management System Overview
        </p>

    </div>

    <div class="row text-center">

        <!-- Total Students -->

        <div class="col-md-6 col-lg-3 mb-3">

            <div class="card border-primary shadow h-100">

                <div class="card-body">

                    <h5 class="text-primary">
                        Total Students
                    </h5>

                    <h2>
                        ${total}
                    </h2>

                </div>

            </div>

        </div>


        <!-- Highest Marks -->

        <div class="col-md-6 col-lg-3 mb-3">

            <div class="card border-success shadow h-100">

                <div class="card-body">

                    <h5 class="text-success">
                        Highest Marks
                    </h5>

                    <h2>
                        ${highest}
                    </h2>

                </div>

            </div>

        </div>


        <!-- Average Marks -->

        <div class="col-md-6 col-lg-3 mb-3">

            <div class="card border-warning shadow h-100">

                <div class="card-body">

                    <h5 class="text-warning">
                        Average Marks
                    </h5>

                    <h2>
                        ${average}
                    </h2>

                </div>

            </div>

        </div>


        <!-- Lowest Marks -->

        <div class="col-md-6 col-lg-3 mb-3">

            <div class="card border-danger shadow h-100">

                <div class="card-body">

                    <h5 class="text-danger">
                        Lowest Marks
                    </h5>

                    <h2>
                        ${lowest}
                    </h2>

                </div>

            </div>

        </div>

    </div>


    <div class="text-center mt-4">

        <a href="add-student.jsp"
           class="btn btn-success btn-lg me-2">

            Add Student

        </a>

        <a href="viewStudents"
           class="btn btn-primary btn-lg">

            View Students

        </a>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js">
</script>

</body>
</html>