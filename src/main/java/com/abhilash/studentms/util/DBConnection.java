package com.abhilash.studentms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = System.getenv("STUDENT_DB_URL");
    private static final String USERNAME = System.getenv("STUDENT_DB_USERNAME");
    private static final String PASSWORD = System.getenv("STUDENT_DB_PASSWORD");

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Oracle JDBC Driver not found.", e);
        }
    }

    public static Connection getConnection() throws SQLException {

        if (URL == null || USERNAME == null || PASSWORD == null) {
            throw new SQLException(
                    "Database environment variables are not configured."
            );
        }

        return DriverManager.getConnection(
                URL,
                USERNAME,
                PASSWORD
        );
    }
}