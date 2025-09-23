package com.myapp.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnection { // New class for managing DB connections
    private static final String URL = "jdbc:sqlite:notes.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
