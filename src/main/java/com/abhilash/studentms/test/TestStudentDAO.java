package com.abhilash.studentms.test;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.dao.StudentDAOImpl;
import com.abhilash.studentms.model.Student;

public class TestStudentDAO {

    public static void main(String[] args) {

        Student student = new Student(
                1,
                "Abhilash",
                "abhilash@gmail.com",
                "Java",
                95
        );

        StudentDAO dao = new StudentDAOImpl();

        System.out.println(dao.addStudent(student));
    }
}