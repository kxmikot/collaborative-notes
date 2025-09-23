package com.myapp.model;

public class Note { // New Note model class
    private int id;
    private int userId;
    private String title;
    private String content;

    public Note(int id, int userId, String title, String content) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public Note(int userId, String title, String content) { // Constructor without id for new notes
        this(-1, userId, title, content);
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getTitle() { return title; }
    public String getContent() { return content; }

    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
}
