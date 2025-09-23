package com.myapp;

import java.sql.*;

import com.myapp.dao.UserDAO;
import com.myapp.service.AuthService;

public class App {
    public static void main(String[] args) {
        new UserDAO().createTable();

        AuthService authService = new AuthService();
        boolean registered = authService.register("user1", "pass123");
        System.out.println("Registered " + registered);

        boolean loggedIn = authService.login("user1", "pass123");
        System.out.println("Logged in: " + loggedIn);
    }
}
