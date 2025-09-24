package com.myapp.network;

import java.io.*;
import java.net.*;
import com.myapp.model.Note;
import com.myapp.service.*;

public class NoteClient {
    private String host;
    private int port;

    public NoteClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void sendNote(Note note) {
        try (
            Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            NoteService noteService = new NoteService();
            String serialized = noteService.serializeNote(note);


            out.println(serialized);
            String response = in.readLine();
            System.out.println("Response from server: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
