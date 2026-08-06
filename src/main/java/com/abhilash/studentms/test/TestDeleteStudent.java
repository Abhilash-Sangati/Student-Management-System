package com.abhilash.studentms.test;

import com.abhilash.studentms.dao.StudentDAO;

public class TestDeleteStudent {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        System.out.println(dao.deleteStudent(1));
    }
}