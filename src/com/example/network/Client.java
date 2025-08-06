package com.example.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] arg) {
        String serverIP = "localhost";
        int serverPort = 8080;
        try (Socket socket = new Socket(serverIP, serverPort)) {
            System.out.println("Connected success");

            BufferedReader bf = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String greeting = bf.readLine();
            System.out.println("Server: " + greeting);

            String name = "Anastasia";
            output.println(name);
            System.out.println("Send: " + name);

            String responce = bf.readLine();
            System.out.println(responce );

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}