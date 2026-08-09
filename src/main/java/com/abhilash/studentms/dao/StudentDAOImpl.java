package com.abhilash.studentms.dao;

import com.abhilash.studentms.model.Student;
import com.abhilash.studentms.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO STUDENT (ID, NAME, EMAIL, COURSE, MARKS) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getCourse());
            ps.setDouble(5, student.getMarks());

            ps.executeUpdate();
            return true;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate ID or Email.");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT ORDER BY ID";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("EMAIL"),
                        rs.getString("COURSE"),
                        rs.getDouble("MARKS")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM STUDENT WHERE ID = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("ID"),
                            rs.getString("NAME"),
                            rs.getString("EMAIL"),
                            rs.getString("COURSE"),
                            rs.getDouble("MARKS")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateStudent(Student student) {
        String sql = "UPDATE STUDENT SET NAME=?, EMAIL=?, COURSE=?, MARKS=? WHERE ID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setDouble(4, student.getMarks());
            ps.setInt(5, student.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Email already exists.");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM STUDENT WHERE ID=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Student> searchStudents(String keyword) {
        List<Student> students = new ArrayList<>();

        String sql = """
                SELECT * FROM STUDENT
                WHERE LOWER(NAME) LIKE ?
                   OR LOWER(COURSE) LIKE ?
                   OR LOWER(EMAIL) LIKE ?
                ORDER BY ID
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String search = "%" + keyword.toLowerCase() + "%";
            ps.setString(1, search);
            ps.setString(2, search);
            ps.setString(3, search);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    students.add(new Student(
                            rs.getInt("ID"),
                            rs.getString("NAME"),
                            rs.getString("EMAIL"),
                            rs.getString("COURSE"),
                            rs.getDouble("MARKS")
                    ));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}