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
            out.println("Connessione stabilita ('END' per terminarla, '?' per aiuto): ");
            out.flush();
            while (true) {
                String str = in.readLine();
                if (str.equals("END"))
                    break;

                if(str.equals("?")) {
                    out.print("COMANDI INSERIBILI:" +
                            "\nricerca_comune -> visualizza tutte le strutture in un determinato comune. " +
                            "\nricerca_provincia -> visualizza tutte le strutture in una determinata provincia. " +
                            "\nricerca_tipologia -> visualizza tutte le strutture in una determinata tipologia. " +
                            "\nricerca_categoria -> visualizza tutte le strutture in una determinata categoria. " +
                            "\nricerca_stelle -> visualizza tutte le strutture con un determinato numero di stelle. " +
                            "\nricerca_denominazione -> visualizza la struttura con una determinata denominazione. " +
                            "\nricerca_indirizzo -> visualizza la struttura presente in un determinato indirizzo. " +
                            "\nricerca_CAP -> visualizza le strutture presenti in un determinato CAP. " +
                            "\nricerca_numero_telefono -> visualizza la struttura con un determinato numero di telefono. " +
                            "\nricerca_fax -> visualizza la struttura con un determinato fax. " +
                            "\nricerca_posta_elettronica -> visualizza la struttura con una determinata posta elettronica. " +
                            "\nricerca_zona -> visualizza le strutture presenti in una determinata zona. " +
                            "\nricerca_feature -> visualizza le struttre con una determinata feature. " +
                            "\nricerca_ambiente ->visualizza le strutture con un determinato ambiente circostante. " +
                            "\nricerca_lingua -> visualizza le strutture in cui si parla una determinata lingua. " +
                            "\nricerca_codice -> visualizza la struttura con un determinato codice identificativo. " +
                            "\nGET_ROW -> visualizza la struttura nella determinata riga. \n");
                }
                String[] words = str.split(" ", 2);


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
