package com.example.FinalProject.Controllers.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public Client(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToServer(String message) {
        try {
            out.write(message);
            out.newLine();
            out.flush(); // Ensure the message is sent immediately
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receiveMessageFromServer() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    while (socket.isConnected()) {
                        String message = in.readLine();
                        if (message != null) {
                            // Handle received message
                            System.out.println("Received from server: " + message);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start(); // Start the thread
    }

    public void closeEverything() {
        try {
            // Close resources without checking for null explicitly
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Change this to the server's IP address
        int serverPort = 12345; // Change this to the server's port

        Client client = new Client(serverAddress, serverPort);
        client.receiveMessageFromServer(); // Start listening for messages from the server

        // Example: sending a message to the server
        client.sendMessageToServer("Hello, server!");
    }
}