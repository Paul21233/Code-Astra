package com.example.FinalProject.Controllers.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;

    public Server(ServerSocket serverSocket) {
        try {
            this.serverSocket = serverSocket;
            this.clientSocket = serverSocket.accept();

            this.in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            this.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMessageToclient(String message){
        try{
            out.write(message);
            out.newLine();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void recieveMessageFromClient(){
        new Thread(new Runnable() {
            public void run() {
                while(serverSocket.isBound()){
                    String message = in.readLine();
                    ChatController.addLabel(message, vbox);
                }
            }
        })
    }

    public void closeEverything(Socket socket, BufferedReader in, BufferedWriter out){
        try{
            if(in != null){
                in.close();
            }

            if(out != null){
                out.close();
            }

            if(socket != null){
                socket.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
