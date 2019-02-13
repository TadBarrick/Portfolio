package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args)  {


        try {
            ServerSocket serverSocket = new ServerSocket(80);
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader stdInput = new BufferedReader(streamReader);
            PrintWriter stdOutput = new PrintWriter(socket.getOutputStream(),true);
            while (true){
                String inputString = stdInput.readLine();
                if (inputString.equals("exit")){
                    System.out.println("Stopping server");
                    System.exit(0);
                }
                stdOutput.println("Echo from server: "+ inputString);
            }
        } catch (IOException e) {
            System.out.println("Unable to establish socket connection");
        }

    }
}
