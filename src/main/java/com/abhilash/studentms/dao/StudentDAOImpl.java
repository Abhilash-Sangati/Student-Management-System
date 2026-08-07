package com.abhilash.studentms.dao;

import com.abhilash.studentms.model.Student;
import com.abhilash.studentms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Student student) {

        String sql = "INSERT INTO STUDENT(ID, NAME, EMAIL, COURSE, MARKS) VALUES(?, ?, ?, ?, ?)";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getCourse());
            preparedStatement.setDouble(5, student.getMarks());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> studentList = new ArrayList<>();

        String sql = "SELECT * FROM STUDENT";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {

                Student student = new Student();

                student.setId(resultSet.getInt("ID"));
                student.setName(resultSet.getString("NAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setCourse(resultSet.getString("COURSE"));
                student.setMarks(resultSet.getDouble("MARKS"));

                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public Student getStudentById(int id) {

        String sql = "SELECT * FROM STUDENT WHERE ID=?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Student student = new Student();

                student.setId(resultSet.getInt("ID"));
                student.setName(resultSet.getString("NAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setCourse(resultSet.getString("COURSE"));
                student.setMarks(resultSet.getDouble("MARKS"));

                return student;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateStudent(Student student) {

        String sql = "UPDATE STUDENT SET NAME=?, EMAIL=?, COURSE=?, MARKS=? WHERE ID=?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getCourse());
            preparedStatement.setDouble(4, student.getMarks());
            preparedStatement.setInt(5, student.getId());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteStudent(int id) {

        String sql = "DELETE FROM STUDENT WHERE ID=?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Student> searchStudents(String keyword) {

        List<Student> studentList = new ArrayList<>();

        String sql = """
            SELECT *
            FROM STUDENT
            WHERE LOWER(NAME) LIKE ?
               OR LOWER(COURSE) LIKE ?
               OR LOWER(EMAIL) LIKE ?
            ORDER BY ID
            """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            String search = "%" + keyword.toLowerCase() + "%";

            preparedStatement.setString(1, search);
            preparedStatement.setString(2, search);
            preparedStatement.setString(3, search);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Student student = new Student();

                student.setId(resultSet.getInt("ID"));
                student.setName(resultSet.getString("NAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setCourse(resultSet.getString("COURSE"));
                student.setMarks(resultSet.getDouble("MARKS"));

                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }
}