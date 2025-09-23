package com.myapp;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Collaborative Notes App started!");
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:notes.db")) {
            if (conn != null) {
                System.out.println("Connected to SQLite database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
