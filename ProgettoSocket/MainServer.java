// package me.ms;

import java.io.*;
import java.net.*;

/**
 *
 * @author Jacopo Olivo
 */
public class MainServer {

    public static final int PORT = 1050; // porta al di fuori del range 1-1024 !

    /**
     * @param args the command line arguments
     * @throws java.io.IOException\
     */
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("EchoServer MultiThread: started ");
            System.out.println("Server Socket: " + serverSocket);

            while (true) {
                // bloccante finchè non avviene una connessione
                Socket clientSocket = serverSocket.accept();

                ServerThread thread = new ServerThread(clientSocket);
                thread.start();
            }
        } catch (IOException ioe) {
            System.err.println("Server error: " + ioe.getMessage());
            System.exit(1);
        }
    }
}