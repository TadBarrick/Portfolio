package com.jatc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        int portNumber = 2222;
        ServerSocket dataServer = null;
        Socket clientSocket = null;
        String inputLine;
        //DataInputStream inputStream;
        BufferedReader inputReader = null;
        PrintStream outputStream;

        // Open server socket on port 2222
        try {
            dataServer = new ServerSocket((portNumber));
            System.out.println("Socket Established");
        } catch (IOException e) {
            System.out.println("Error opening socket");
            e.printStackTrace();
        }

        // Create socket object from the ServerSocket to listen for an accept
        // connections.  Open input and output streams for data communication
        try {
            clientSocket = dataServer.accept();
            inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outputStream = new PrintStream(clientSocket.getOutputStream());
            while(true) {
                inputLine = inputReader.readLine();
                System.out.println(inputLine);
                outputStream.println("Hello from server");
            }
        } catch (IOException e) {
            System.out.println("Communication Error");
            e.printStackTrace();
        }
    }
}
