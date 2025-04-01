// package me.ms;

import java.io.*;
import java.net.*;

/**
 *
 * @author Jacopo Olivo
 */
public class ServerThreads extends Thread {

    private Socket clientSocket;
    private BufferedReader in = null;
    private PrintWriter out = null;

    public ServerThreads(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Connection accepted: " + clientSocket);

            // creazione stream di input da clientSocket
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(isr);

            // creazione stream di output su clientSocket
            OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            out = new PrintWriter(bw, true);

            // ciclo di ricezione dal client e invio di risposta
            out.println("Hello (END to close connection): ");
            out.flush();
            while (true) {
                String str = in.readLine();
                if (str.equals("END"))
                    break;
                System.out.println("Echoing: " + str.toUpperCase());
                out.println(str.toUpperCase());
            }

            // chiusura di stream e socket
            System.out.println("EchoServer: closing...");
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Accept failed");
            // System.exit(1);
        }
    }
}
