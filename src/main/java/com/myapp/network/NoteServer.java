package com.myapp.network;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import com.myapp.service.*;
import com.myapp.model.Note;

public class NoteServer {
    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public NoteServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        pool = Executors.newFixedThreadPool(10);
    }

    public void start() {
        System.out.println("Server started...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                pool.execute(() -> handleClient(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleClient(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){
            String message = in.readLine();
            System.out.println("Received raw: " + message);

            NoteService noteService = new NoteService();
            Note note = noteService.deserializeNote(message, 1);
            noteService.createNote(note.getId(), note.getTitle(), note.getContent());


            out.println("note saved on server: " + note.getTitle());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
