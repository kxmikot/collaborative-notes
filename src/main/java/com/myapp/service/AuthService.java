package com.myapp.service;

import com.myapp.dao.UserDAO;
import com.myapp.model.User;

public class AuthService {
    private final UserDAO userDAO = new UserDAO();

    public boolean register(String username, String password) {
        if (userDAO.getUserByUsername(username) != null) {
            return false;
        } else {
            UserDAO.addUser(new User(username, password));
            return true;
        }
    }

    public boolean login(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
