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

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<jsp:include page="includes/navbar.jsp"/>

<div class="container mt-5">

    <div class="card shadow mx-auto" style="max-width: 650px;">

        <div class="card-header bg-warning">

            <h3 class="mb-0">
                Edit Student
            </h3>

        </div>

        <div class="card-body">

            <% if ("error".equals(request.getParameter("error"))) { %>

            <div class="alert alert-danger">
                Unable to update student. Please check the entered details.
            </div>

            <% } %>


            <form action="updateStudent"
                  method="post">

                <!-- Student ID -->

                <div class="mb-3">

                    <label class="form-label">
                        Student ID
                    </label>

                    <input type="number"
                           name="id"
                           class="form-control"
                           value="<%= student.getId() %>"
                           readonly>

                </div>


                <!-- Name -->

                <div class="mb-3">

                    <label class="form-label">
                        Name
                    </label>

                    <input type="text"
                           name="name"
                           class="form-control"
                           value="<%= student.getName() %>"
                           minlength="2"
                           maxlength="50"
                           required>

                </div>


                <!-- Email -->

                <div class="mb-3">

                    <label class="form-label">
                        Email
                    </label>

                    <input type="email"
                           name="email"
                           class="form-control"
                           value="<%= student.getEmail() %>"
                           maxlength="100"
                           required>

                </div>


                <!-- Course -->

                <div class="mb-3">

                    <label class="form-label">
                        Course
                    </label>

                    <input type="text"
                           name="course"
                           class="form-control"
                           value="<%= student.getCourse() %>"
                           minlength="2"
                           maxlength="50"
                           required>

                </div>


                <!-- Marks -->

                <div class="mb-3">

                    <label class="form-label">
                        Marks
                    </label>

                    <input type="number"
                           name="marks"
                           class="form-control"
                           value="<%= student.getMarks() %>"
                           min="0"
                           max="100"
                           step="0.01"
                           required>

                    <div class="form-text">
                        Marks must be between 0 and 100.
                    </div>

                </div>


                <div class="d-flex gap-2">

                    <button type="submit"
                            class="btn btn-success">

                        Update Student

                    </button>

                    <a href="viewStudents"
                       class="btn btn-secondary">

                        Cancel

                    </a>

                </div>

            </form>

        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js">
</script>

</body>
</html>