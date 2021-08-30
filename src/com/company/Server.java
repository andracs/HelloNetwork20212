/**
 * Developed by András Ács (acsandras@gmail.com)
 * Zealand / www.zealand.dk
 * Licensed under the MIT License
 * 30/08/2021
 */
package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {
            // Trin 1 - Lav server socket
            ServerSocket serverSocket = new ServerSocket(1978);

            // Trin 2 - Få en socket til at lytte på den angiven port
            System.out.println("Accepting connection on port 1978.");
            Socket socket = serverSocket.accept();
            System.out.println("Connection estabilished " + socket.getRemoteSocketAddress().toString());

            // Trin 3 - Data in og out
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Trin 4 - Her kan man sende og modtage data
            String incomingText = inputStream.readUTF(); // Jeg læser en string på port 1978
            outputStream.writeChars("Tak for teksten, den er modtaget.");
            outputStream.flush();





        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
