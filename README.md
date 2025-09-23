# Collaborative Notes App

A simple **Java + SQLite** project for managing notes with version history.  
Demonstrates working with **plain Java**, JDBC, and a layered application structure using DAO and service layers.

---

## 📁 Project Structure

collaborative-notes-app/
├─ src/
│ ├─ main/
│ │ └─ java/
│ │ └─ com/
│ │ └─ myapp/
│ │ ├─ model/ # Data models: User, Note, NoteVersion
│ │ ├─ dao/ # Data Access Objects for database operations
│ │ ├─ service/ # Business logic (AuthService, NoteService)
│ │ └─ App.java # Main entry point
├─ lib/
│ └─ sqlite-jdbc.jar # SQLite JDBC driver
├─ notes.db # Local SQLite database
├─ README.md
├─ .gitignore
└─ LICENSE


---

## 📝 Description of Packages and Files

### **model/**
- `User` – represents a user (id, username, password)  
- `Note` – represents a note (id, userId, title, content)  
- `NoteVersion` – represents a version of a note (id, noteId, content, createdAt)  

### **dao/**
Handles database operations:
- `DBConnection` – centralized SQLite connection  
- `UserDAO` – CRUD operations on `users` table  
- `NoteDAO` – CRUD operations on `notes` table  
- `NoteVersionDAO` – CRUD operations on `note_versions` table  

### **service/**
Business logic layer:
- `AuthService` – user registration and login  
- `NoteService` – create, edit, and retrieve notes  

### **App.java**
Main entry point of the application, demonstrates DAO and service usage.

---

## ⚡ Usage Examples

### User Registration and Login
```java
AuthService authService = new AuthService();
authService.register("user1", "pass123"); // register a new user
boolean loggedIn = authService.login("user1", "pass123"); // login
System.out.println("Logged in: " + loggedIn);
```

### Creating a Note
```
NoteService noteService = new NoteService();
noteService.createNote(1, "My First Note", "This is the note content.");
```