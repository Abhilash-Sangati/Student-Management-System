package com.abhilash.studentms.test;

import com.abhilash.studentms.dao.AdminDAO;
import com.abhilash.studentms.dao.AdminDAOImpl;

public class TestAdminDAO {

    public static void main(String[] args) {

        AdminDAO dao = new AdminDAOImpl();

        boolean result = dao.validateAdmin("admin", "admin123");

        if (result) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Invalid Username or Password");
        }

    }
}