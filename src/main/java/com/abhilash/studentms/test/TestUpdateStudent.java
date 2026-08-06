package com.abhilash.studentms.test;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.model.Student;

public class TestUpdateStudent {

    public static void main(String[] args) {

        Student student = new Student(
                1,
                "Abhilash Kumar",
                "abhilash@gmail.com",
                "Advanced Java",
                99
        );

        StudentDAO dao = new StudentDAO();

        System.out.println(dao.updateStudent(student));
    }
}