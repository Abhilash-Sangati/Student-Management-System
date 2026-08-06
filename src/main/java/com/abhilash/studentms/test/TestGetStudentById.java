package com.abhilash.studentms.test;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.dao.StudentDAOImpl;

public class TestGetStudentById {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();

        System.out.println(dao.getStudentById(1));
    }
}