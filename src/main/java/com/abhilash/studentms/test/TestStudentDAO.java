package com.abhilash.studentms.test;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.model.Student;

public class TestStudentDAO {

    public static void main(String[] args) {

        Student student = new Student();

        student.setId(1);
        student.setName("Abhilash");
        student.setEmail("abhilash@gmail.com");
        student.setCourse("Java");
        student.setMarks(95);

        StudentDAO studentDAO = new StudentDAO();

        boolean result = studentDAO.addStudent(student);

        if (result) {
            System.out.println("Student Added Successfully.");
        } else {
            System.out.println("Failed to Add Student.");
        }
    }
}