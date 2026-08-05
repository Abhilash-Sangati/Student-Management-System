package com.abhilash.studentms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/orclpdb";
    private static final String USERNAME = "Abhilash";
    private static final String PASSWORD = "abhi123";

    public static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Database Connected Successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver Not Found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database Connection Failed.");
            e.printStackTrace();
        }

        return connection;
    }
}