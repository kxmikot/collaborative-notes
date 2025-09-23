package com.myapp.dao;

import java.sql.*;
import com.myapp.model.Note;


public class NoteDAO { // New DAO class for Note entity
    public void createTable() { // Method to create notes table if it doesn't exist
        String sql = "CREATE TABLE IF NOT EXISTS notes (\n"
                   + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                   + " user_id INTEGER NOT NULL,\n"
                   + " title TEXT NOT NULL,\n"
                   + " content TEXT NOT NULL,\n"
                   + " FOREIGN KEY (user_id) REFERENCES users(id)\n"
                   + ");";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNote(Note note) { // Method to add a new note
        String sql = "INSERT INTO notes(user_id, title, content) VALUES(?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, note.getUserId());
            pstmt.setString(2, note.getTitle());
            pstmt.setString(3, note.getContent());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNote(Note note) { // Method to update an existing note
        String sql = "UPDATE notes SET title = ?, content = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, note.getTitle());
                pstmt.setString(2, note.getContent());
                pstmt.setInt(3, note.getId());
                pstmt.executeUpdate();

                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    note.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
            e.printStackTrace();
    }
}
