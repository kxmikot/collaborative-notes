package com.myapp.service;

import com.myapp.dao.NoteDAO;
import com.myapp.model.Note;
import java.util.List;

public class NoteService {
    private final NoteDAO noteDAO = new NoteDAO();

    public void createNote(int userId, String title, String content) {
        noteDAO.addNote(new Note(userId, title, content));
    }

    public List<Note> getUserNotes(int userId) {
        return noteDAO.getNotesByUserId(userId);
    }
}
