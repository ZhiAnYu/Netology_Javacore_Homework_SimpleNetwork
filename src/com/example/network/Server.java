package com.example.network;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
        int port = 8080; //диапазон 1024-65388
        System.out.println("Starting server on port: " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    String clientIp = clientSocket.getInetAddress().getHostAddress();
                    int clientPort = clientSocket.getPort();
                    System.out.println("Accepted connection from:");
                    System.out.println("IP client:" + clientIp);
                    System.out.println("Port сliient: " + clientPort);
                    BufferedReader bf = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
                    output.println("Welcome! Write your name, please!");
                    String message = bf.readLine();
                    String responce = String.format("Welcome, %s! Your port: %d ", message, clientPort);
                    output.println(responce);
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}











