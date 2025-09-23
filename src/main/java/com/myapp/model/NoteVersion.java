package com.myapp.model;
import java.time.LocalDateTime;

public class NoteVersion { // New class for NoteVersion entity
    private int id;
    private int noteId;
    private String content;
    private LocalDateTime createdAt;

    public NoteVersion(int id, int noteId, String content, LocalDateTime createdAt) {
        this.id = id;
        this.noteId = noteId;
        this.content = content;
        this.createdAt = createdAt;
    }
    
    public NoteVersion(int noteId, String content) { // Constructor without id for new versions
        this(-1, noteId, content, LocalDateTime.now());
    }

    public int getId() { return id; }
    public int getNoteId() { return noteId; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(int id) { this.id = id; }
}
