package com.abhilash.studentms.test;

import com.abhilash.studentms.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {

        try {
            Connection connection = DBConnection.getConnection();

            if (connection != null) {
                System.out.println("Connection Successful!");
                connection.close();
            } else {
                System.out.println("Connection Failed!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }
}