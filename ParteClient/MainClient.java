import java.io.*;
import java.net.*;
import java.util.*;

public class MainClient {
    final static String ADDRESS = "127.0.0.1";
    final static int PORT = 1050;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //new Menu();
        try {
            System.out.println("Inserisci l'indirizzo del server (default: " + ADDRESS + "):");
            String serverInput = input.nextLine().trim();
            String server;
            if (serverInput.isEmpty()) {
                server = ADDRESS;
            } else {
                server = serverInput;
            }

            System.out.println("Inserisci la porta del server (default: " + PORT + "):");
            String portInput = input.nextLine().trim();
            int porta;
            if (portInput.isEmpty()) {
                porta = PORT;
            } else {
                porta = Integer.parseInt(portInput);
            }

            InetAddress serverAddress = InetAddress.getByName(server);
            Socket socket = new Socket(serverAddress, porta);
            System.out.println("Connessione al server " + socket.getInetAddress() + " sulla porta " + socket.getPort());

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String command;
            while (true) {
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.equals("END_OF_MESSAGE")) break;
                    System.out.println(line);
                }

                System.out.print("> ");
                command = input.nextLine();

                if (command.equalsIgnoreCase("END")) {
                    out.println("END");
                    break;
                }

                out.println(command);
            }

            out.close();
            in.close();
            socket.close();
            input.close();
            System.out.println("Connessione chiusa.");
        } catch (IOException e) {
            System.err.println("Errore durante la connessione al server: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Porta non valida. Deve essere un numero intero.");
        }
    }
}
