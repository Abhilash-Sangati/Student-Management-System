package com.abhilash.studentms.test;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.dao.StudentDAOImpl;
import com.abhilash.studentms.model.Student;

import java.util.List;

public class TestGetAllStudents {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();

        List<Student> students = dao.getAllStudents();

        for (Student student : students) {
            System.out.println(student);
        }
    }
}