<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.abhilash.studentms.model.Student" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Students</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet">
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
            <div class="alert alert-success">
                Student added successfully!
            </div>
            <% } %>

            <% if ("updated".equals(request.getParameter("success"))) { %>
            <div class="alert alert-success">
                Student updated successfully!
            </div>
            <% } %>

            <% if ("deleted".equals(request.getParameter("success"))) { %>
            <div class="alert alert-success">
                Student deleted successfully!
            </div>
            <% } %>

            <% if ("delete".equals(request.getParameter("error"))) { %>
            <div class="alert alert-danger">
                Failed to delete student.
            </div>
            <% } %>

            <% if ("invalidId".equals(request.getParameter("error"))) { %>
            <div class="alert alert-danger">
                Invalid student ID.
            </div>
            <% } %>

            <% if ("notFound".equals(request.getParameter("error"))) { %>
            <div class="alert alert-danger">
                Student not found.
            </div>
            <% } %>


            <%
                String keyword = (String) request.getAttribute("keyword");

                if (keyword == null) {
                    keyword = "";
                }

                String sortBy = (String) request.getAttribute("sortBy");

                if (sortBy == null) {
                    sortBy = "id";
                }

                String sortOrder = (String) request.getAttribute("sortOrder");

                if (sortOrder == null) {
                    sortOrder = "asc";
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

                List<Student> studentList =
                        (List<Student>) request.getAttribute("studentList");
            %>


            <!-- Search -->

            <form action="searchStudent"
                  method="get"
                  class="mb-4">

                <div class="input-group">

                    <input type="text"
                           name="keyword"
                           class="form-control"
                           placeholder="Search by ID, Name, Course or Email"
                           value="<%= keyword %>">

                    <input type="hidden"
                           name="sortBy"
                           value="<%= sortBy %>">

                    <input type="hidden"
                           name="sortOrder"
                           value="<%= sortOrder %>">

                    <button class="btn btn-primary"
                            type="submit">

                        Search

                    </button>

                    <a href="viewStudents"
                       class="btn btn-secondary">

                        Reset

                    </a>

                </div>

            </form>


            <!-- Sorting -->

            <form action="<%= keyword.isEmpty()
                    ? "viewStudents"
                    : "searchStudent" %>"
                  method="get"
                  class="row g-2 mb-4">

                <input type="hidden"
                       name="keyword"
                       value="<%= keyword %>">

                <div class="col-md-4">

                    <select name="sortBy"
                            class="form-select">

                        <option value="id"
                                <%= "id".equals(sortBy)
                                        ? "selected"
                                        : "" %>>

                            Sort by ID

                        </option>

                        <option value="name"
                                <%= "name".equals(sortBy)
                                        ? "selected"
                                        : "" %>>

                            Sort by Name

                        </option>

                        <option value="email"
                                <%= "email".equals(sortBy)
                                        ? "selected"
                                        : "" %>>

                            Sort by Email

                        </option>

                        <option value="course"
                                <%= "course".equals(sortBy)
                                        ? "selected"
                                        : "" %>>

                            Sort by Course

                        </option>

                        <option value="marks"
                                <%= "marks".equals(sortBy)
                                        ? "selected"
                                        : "" %>>

                            Sort by Marks

                        </option>

                    </select>

                </div>


                <div class="col-md-4">

                    <select name="sortOrder"
                            class="form-select">

                        <option value="asc"
                                <%= "asc".equals(sortOrder)
                                        ? "selected"
                                        : "" %>>

                            Ascending

                        </option>

                        <option value="desc"
                                <%= "desc".equals(sortOrder)
                                        ? "selected"
                                        : "" %>>

                            Descending

                        </option>

                    </select>

                </div>


                <div class="col-md-4">

                    <button class="btn btn-success w-100"
                            type="submit">

                        Apply Sorting

                    </button>

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

                    <th>View</th>

                    <th>Edit</th>

                    <th>Delete</th>

                </tr>

                </thead>


                <tbody>

                <%
                    if (studentList != null &&
                            !studentList.isEmpty()) {

                        for (Student student : studentList) {
                %>

                <tr>

                    <td>
                        <%= student.getId() %>
                    </td>

                    <td>
                        <%= student.getName() %>
                    </td>

                    <td>
                        <%= student.getEmail() %>
                    </td>

                    <td>
                        <%= student.getCourse() %>
                    </td>

                    <td>
                        <%= student.getMarks() %>
                    </td>


                    <!-- View -->

                    <td>

                        <a href="studentDetails?id=<%= student.getId() %>"
                           class="btn btn-info btn-sm">

                            View

                        </a>

                    </td>


                    <!-- Edit -->

                    <td>

                        <a href="editStudent?id=<%= student.getId() %>"
                           class="btn btn-warning btn-sm">

                            Edit

                        </a>

                    </td>


                    <!-- Delete -->

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

                    <td colspan="8"
                        class="text-center text-danger">

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
                           href="searchStudent?keyword=<%= keyword %>&sortBy=<%= sortBy %>&sortOrder=<%= sortOrder %>&page=<%= currentPage - 1 %>">

                            Previous

                        </a>

                        <% } else { %>

                        <a class="page-link"
                           href="viewStudents?sortBy=<%= sortBy %>&sortOrder=<%= sortOrder %>&page=<%= currentPage - 1 %>">

                            Previous

                        </a>

                        <% } %>

                    </li>

                    <% } %>


                    <% for (int i = 1;
                            i <= totalPages;
                            i++) { %>

                    <li class="page-item
                        <%= i == currentPage
                                ? "active"
                                : "" %>">

                        <% if (!keyword.isEmpty()) { %>

                        <a class="page-link"
                           href="searchStudent?keyword=<%= keyword %>&sortBy=<%= sortBy %>&sortOrder=<%= sortOrder %>&page=<%= i %>">

                            <%= i %>

                        </a>

                        <% } else { %>

                        <a class="page-link"
                           href="viewStudents?sortBy=<%= sortBy %>&sortOrder=<%= sortOrder %>&page=<%= i %>">

                            <%= i %>

                        </a>

                        <% } %>

                    </li>

                    <% } %>


                    <% if (currentPage < totalPages) { %>

                    <li class="page-item">

                        <% if (!keyword.isEmpty()) { %>

                        <a class="page-link"
                           href="searchStudent?keyword=<%= keyword %>&sortBy=<%= sortBy %>&sortOrder=<%= sortOrder %>&page=<%= currentPage + 1 %>">

                            Next

                        </a>

                        <% } else { %>

                        <a class="page-link"
                           href="viewStudents?sortBy=<%= sortBy %>&sortOrder=<%= sortOrder %>&page=<%= currentPage + 1 %>">

                            Next

                        </a>

                        <% } %>

                    </li>

                    <% } %>

                </ul>

            </nav>

            <% } %>


            <a href="dashboard"
               class="btn btn-secondary">

                Back

            </a>

        </div>

    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js">
</script>

</body>
</html>