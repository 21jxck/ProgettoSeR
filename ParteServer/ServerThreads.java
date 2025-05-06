// package me.ms;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Jacopo Olivo
 */
public class ServerThreads extends Thread {

    private Socket clientSocket;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private CSVReader csvr = new CSVReader();
    private List<Data> currentContent = csvr.fileContent;

    public ServerThreads(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Connection accepted: " + clientSocket);

            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(isr);

            OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);
            out = new PrintWriter(bw, true);

            out.println("Connessione stabilita ('END' per terminarla, '?' per aiuto): ");
            out.println("END_MESSAGE");
            out.flush();

            while (true) {
                String str = in.readLine();
                if (str.equals("END"))
                    break;

                System.out.println("Messaggio client: " + str);

                if (str.equals("?")) {
                    out.print("COMANDI INSERIBILI:" +
                            "\n\rEND                        -> termina la connessione. " +
                            "\n\rnuova_ricerca              -> inizializza una nuova ricerca, rimuovendo i filtri precedenti. "
                            +
                            "\n\rricerca_comune             -> visualizza tutte le strutture in un determinato comune. "
                            +
                            "\n\rricerca_provincia          -> visualizza tutte le strutture in una determinata provincia. "
                            +
                            "\n\rricerca_tipologia          -> visualizza tutte le strutture in una determinata tipologia. "
                            +
                            "\n\rricerca_categoria          -> visualizza tutte le strutture in una determinata categoria. "
                            +
                            "\n\rricerca_stelle             -> visualizza tutte le strutture con un determinato numero di stelle. "
                            +
                            "\n\rricerca_denominazione      -> visualizza la struttura con una determinata denominazione. "
                            +
                            "\n\rricerca_indirizzo          -> visualizza la struttura presente in un determinato indirizzo. "
                            +
                            "\n\rricerca_CAP                -> visualizza le strutture presenti in un determinato CAP. "
                            +
                            "\n\rricerca_numeroTelefono     -> visualizza la struttura con un determinato numero di telefono. "
                            +
                            "\n\rricerca_fax                -> visualizza la struttura con un determinato fax. " +
                            "\n\rricerca_postaElettronica   -> visualizza la struttura con una determinata posta elettronica. "
                            +
                            "\n\rricerca_zona               -> visualizza le strutture presenti in una determinata zona. "
                            +
                            "\n\rricerca_feature            -> visualizza le struttre con una determinata feature. " +
                            "\n\rricerca_ambiente           -> visualizza le strutture con un determinato ambiente circostante. "
                            +
                            "\n\rricerca_lingua             -> visualizza le strutture nelle quali si parla una determinata lingua. "
                            +
                            "\n\rricerca_codice             -> visualizza la struttura con un determinato codice identificativo. "
                            +
                            "\n\rGET_ROW                    -> visualizza la struttura nella determinata riga. " +
                            "\n\rALL                        -> visualizza tutte le strutture ricettive della Regione Veneto\n\r"
                            +
                            "\n\rInserisci la caratteristica della struttura ricettiva uno spazio dopo il comando.\n\r");
                    out.flush();
                    out.println("END_MESSAGE");
                    out.flush();
                    continue;
                }

                if (str.equals("nuova_ricerca")) {
                    currentContent = csvr.fileContent;

                    out.println("Nuova ricerca iniziata! ");
                    out.flush();
                    out.println("END_MESSAGE");
                    out.flush();

                    continue;
                }

                String[] words = str.split(" ", 2);

                switch (words[0]) {
                    case "ricerca_comune":
                        List<Data> comune = csvr.researchComune(words[1], currentContent);

                        currentContent = comune;

                        if (comune.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : comune) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_provincia":
                        List<Data> provincia = csvr.researchProvincia(words[1], currentContent);

                        currentContent = provincia;

                        if (provincia.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : provincia) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_tipologia":
                        List<Data> tipologia = csvr.researchTipologia(words[1], currentContent);

                        currentContent = tipologia;

                        if (tipologia.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : tipologia) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_categoria":
                        List<Data> categoria = csvr.researchCategoria(words[1], currentContent);

                        currentContent = categoria;

                        if (categoria.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : categoria) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_stelle":
                        List<Data> stelle = csvr.researchNStelle(words[1], currentContent);

                        currentContent = stelle;

                        if (stelle.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : stelle) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_denominazione":
                        List<Data> denominazione = csvr.researchDenominazione(words[1], currentContent);

                        currentContent = denominazione;

                        if (denominazione.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : denominazione) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_indirizzo":
                        List<Data> indirizzo = csvr.researchIndirizzo(words[1], currentContent);

                        currentContent = indirizzo;

                        if (indirizzo.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : indirizzo) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_CAP":
                        List<Data> cap = csvr.researchCap(words[1], currentContent);

                        currentContent = cap;

                        if (cap.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : cap) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_numeroTelefono":
                        List<Data> numeroTelefono = csvr.researchNTelefono(words[1], currentContent);

                        currentContent = numeroTelefono;

                        if (numeroTelefono.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : numeroTelefono) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_fax":
                        List<Data> fax = csvr.researchFax(words[1], currentContent);

                        currentContent = fax;

                        if (fax.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : fax) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_postaElettronica":
                        List<Data> postaElettronica = csvr.researchPostaElettronica(words[1], currentContent);

                        currentContent = postaElettronica;

                        if (postaElettronica.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : postaElettronica) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_zona":
                        List<Data> zona = csvr.researchZona(words[1], currentContent);

                        currentContent = zona;

                        if (zona.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : zona) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_feature":
                        List<Data> feature = csvr.researchFeature(words[1], currentContent);

                        currentContent = feature;

                        if (feature.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : feature) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_ambiente":
                        List<Data> ambiente = csvr.researchAmbiente(words[1], currentContent);

                        currentContent = ambiente;

                        if (ambiente.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : ambiente) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_lingua":
                        List<Data> lingua = csvr.researchLingua(words[1], currentContent);

                        currentContent = lingua;

                        if (lingua.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : lingua) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "ricerca_codice":
                        List<Data> codice = csvr.researchCodice(words[1], currentContent);

                        currentContent = codice;

                        if (codice.isEmpty()) {
                            out.println("Errore: nessun risultato trovato per la parola " + words[1] + "!");
                            out.flush();
                            break;
                        }

                        for (Data dato : codice) {
                            out.print(dato.toString() + "\n\r");
                            out.flush();
                        }
                        break;
                    case "GET_ROW":
                        if ((Integer.parseInt(words[1]) - 1) < 1
                                && (Integer.parseInt(words[1]) - 1) > csvr.fileContent.size()) {
                            out.println("Errore: il numero è fuori dai limiti! ");
                            out.flush();
                            break;
                        }

                        out.print(csvr.researchRow(Integer.parseInt(words[1]) - 1).toString());
                        out.flush();
                        break;
                    case "ALL":
                        for (Data d : csvr.fileContent)
                            out.println(d.toString());
                        out.flush();
                        break;
                    default:
                        out.print("Errore nel comando! \n\r");
                        out.flush();
                        break;
                }
                out.println("END_MESSAGE");
                out.flush();
            }

            System.out.println("EchoServer: closing...");
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Accept failed");
            e.printStackTrace();
        }
    }
}
