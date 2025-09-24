package com.myapp;

import java.sql.*;

import com.myapp.dao.NoteDAO;
import com.myapp.dao.UserDAO;
import com.myapp.service.AuthService;
import com.myapp.service.NoteService;
import java.util.List;
import com.myapp.model.*;

public class App {
    public static void main(String[] args) {
        new UserDAO().createTable();
        new NoteDAO().createTable();

        AuthService authService = new AuthService();
        boolean registered = authService.register("user1", "pass123");
        System.out.println("Registered " + registered);

        boolean loggedIn = authService.login("user1", "pass123");
        System.out.println("Logged in: " + loggedIn);

        NoteService noteService = new NoteService();
        //noteService.createNote(0, "Java OCA", "Certification");

        List<Note> notes = noteService.getUserNotes(0);
        for (Note n : notes) {
            System.out.println(n.getTitle());
            System.out.println(n.getContent());
        }
    }
}
