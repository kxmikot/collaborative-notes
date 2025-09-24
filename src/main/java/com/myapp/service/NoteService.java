package com.myapp.service;

import com.myapp.dao.NoteDAO;
import com.myapp.model.Note;
import java.util.List;

public class NoteService {
    private final NoteDAO noteDAO = new NoteDAO();

    public void createNote(int userId, String title, String content) {
        Note note = new Note(userId, title, content);
        noteDAO.addNote(note);
    }

    public String serializeNote(Note note) {
        return note.getTitle() + "|" + note.getContent();
    }

    public Note deserializeNote(String data, int userId) {
        String[] parts = data.split("\\|", 2);
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid note format: " + data);
        }
        return new Note(userId, parts[0], parts[1]);
    }

    public List<Note> getUserNotes(int userId) {
        return noteDAO.getNotesByUserId(userId);
    }
}
