package com.abhilash.studentms.test;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.model.Student;

import java.util.List;

public class TestGetAllStudents {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        List<Student> students = studentDAO.getAllStudents();

        for (Student student : students) {
            System.out.println(student);
        }
    }
}