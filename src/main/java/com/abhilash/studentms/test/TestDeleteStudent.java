package com.abhilash.studentms.test;

import com.abhilash.studentms.dao.StudentDAO;
import com.abhilash.studentms.dao.StudentDAOImpl;

public class TestDeleteStudent {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();

        System.out.println(dao.deleteStudent(1));
    }
}