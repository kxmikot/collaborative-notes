package com.myapp.service;

import com.myapp.dao.NoteDAO;
import com.myapp.model.Note;

public class NoteService {
    private final NoteDAO noteDAO = new NoteDAO();

    public void createNote(int userId, String title, String content) {
        noteDAO.addNote(new Note(userId, title, content));
    }
}
