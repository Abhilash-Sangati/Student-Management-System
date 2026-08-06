package com.abhilash.studentms.dao;

import com.abhilash.studentms.model.Student;
import com.abhilash.studentms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    //Inserting or adding the student
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

            int rows = preparedStatement.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //Read the student data
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

    //Get Student By ID
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

    //Updating the student
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

    //Deleting the student
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
}