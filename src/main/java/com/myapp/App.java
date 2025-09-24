package com.myapp;


import com.myapp.model.*;
import com.myapp.network.NoteClient;
import com.myapp.network.NoteServer;

public class App {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                NoteServer server = new NoteServer(12345);
                server.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Note note = new Note(1, "MyTitle", "This is the content");
        NoteClient client = new NoteClient("localhost", 12345);
        client.sendNote(note);
    }
}
