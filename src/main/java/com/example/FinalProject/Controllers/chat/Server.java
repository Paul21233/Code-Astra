package com.example.FinalProject.Controllers.chat;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;

    public Server(ServerSocket serverSocket) {
        try {
            this.serverSocket = serverSocket;
            this.clientSocket = serverSocket.accept();

            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToclient(String message) {
        try {
            out.write(message);
            out.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recieveMessageFromClient(VBox vbox_msg) {
        new Thread(new Runnable() {
            public void run() {
                while (serverSocket.isBound()) {
                    String message = null;
                    try {
                        message = in.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ChatController.addLabel(message, new VBox());
                }
            }
        });
    }

    public void closeEverything(Socket socket, BufferedReader in, BufferedWriter out) {
        try {
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
}
