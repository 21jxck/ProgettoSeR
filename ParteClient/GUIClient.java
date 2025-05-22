import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GUIClient extends JFrame {

    private PrintWriter out;
    private BufferedReader in;
    private JTextArea outputArea;

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public GUIClient() {
        super("Client GUI");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JButton disconnectButton = new JButton("Disconnetti");
        disconnectButton.addActionListener(click -> terminaConnessione());

        String[] opzioniRicerca = {
            "ricerca_comune", "ricerca_provincia", "ricerca_tipologia",
            "ricerca_categoria", "ricerca_stelle", "ricerca_denominazione",
            "ricerca_indirizzo", "ricerca_CAP", "ricerca_numeroTelefono",
            "ricerca_fax", "ricerca_email", "ricerca_zona", "ricerca_feature",
            "ricerca_ambiente", "ricerca_lingua", "ricerca_codice", "GET_ROW",
            "ALL", "?"
        };

        JComboBox<String> ricerche = new JComboBox<>(opzioniRicerca);
        JTextField keywordField = new JTextField(15);

        JButton searchButton = new JButton("Ricerca");
        searchButton.addActionListener(click -> sendMessages(ricerche, keywordField));

        JButton newSearchButton = new JButton("Nuova Ricerca");
        newSearchButton.addActionListener(click -> {
            out.println("nuova_ricerca");
            out.flush();
            outputArea.setText("");
            keywordField.setText("");
        });

        topPanel.add(disconnectButton);
        topPanel.add(ricerche);
        topPanel.add(keywordField);
        topPanel.add(searchButton);
        topPanel.add(newSearchButton);

        return topPanel;
    }

    public void firstMessage() {
        new Thread(() -> {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.equals("END_OF_MESSAGE")) break;
                    outputArea.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void terminaConnessione() {
        new Thread(() -> {
            try {
                if (out != null) {
                    out.println("END");
                    out.flush();
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void sendMessages(JComboBox<String> ricerche, JTextField keywordField) {
        outputArea.setText("");

        String selectedCommand = (String) ricerche.getSelectedItem();
        String keyword = keywordField.getText().trim();

        // Gestione del comando "?"
        if ("?".equals(selectedCommand)) {
            out.println("?");
            out.flush();
            getAnswers();
            return;
        }

        // Controllo per i comandi che richiedono una parola chiave
        if (keyword.isEmpty() && !"ALL".equals(selectedCommand)) {
            JOptionPane.showMessageDialog(this, "Inserisci una parola chiave.", "Attenzione", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Invio del comando con parola chiave
        String messaggio = selectedCommand + " " + keyword;
        out.println(messaggio);
        out.flush();

        getAnswers();
    }

    public void getAnswers() {
        new Thread(() -> {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.equals("END_OF_MESSAGE")) break;
                    outputArea.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
