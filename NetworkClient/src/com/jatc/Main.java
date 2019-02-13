package com.jatc;

import com.pi4j.system.NetworkInfo;
import com.pi4j.system.SystemInfo;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {

       Socket clientSocket = null;
        BufferedReader inputReader;
        PrintStream outputStream = null;
        String serverResponse;

        // Open a socket on port 2222.  Create input and output streams.

        try {
            clientSocket = new Socket("10.213.193.101", 2222);
            outputStream = new PrintStream(clientSocket.getOutputStream());
            inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outputStream.println("Hello from client");
            while((serverResponse = inputReader.readLine()) != null){
                System.out.println(serverResponse);
                outputStream.println("Hello from client");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}