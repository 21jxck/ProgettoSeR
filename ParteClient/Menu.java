import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Menu extends JFrame {

    public Menu() {
        super("Menu Principale");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Aggiungi titolo
        JLabel titolo = new JLabel("STRUTTURE RICETTIVE REGIONE VENETO", SwingConstants.CENTER);
        titolo.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 35));
        add(titolo, BorderLayout.NORTH);

        // Aggiungi pannello con i pulsanti
        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 150, 25, 150));

        JButton connetti = new JButton("Connetti");
        connetti.setPreferredSize(new Dimension(300, 50));
        connetti.setMaximumSize(new Dimension(300, 50));
        connetti.setBackground(Color.CYAN);
        connetti.setForeground(Color.BLACK);
        connetti.addActionListener(click -> inizializzazione());
        connetti.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton esci = new JButton("Esci");
        esci.setPreferredSize(new Dimension(200, 50));
        esci.setMaximumSize(new Dimension(200, 50));
        esci.setBackground(Color.GRAY);
        esci.setForeground(Color.WHITE);
        esci.addActionListener(click -> System.exit(0));
        esci.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel.add(connetti);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        buttonPanel.add(esci);

        return buttonPanel;
    }

    public void inizializzazione() {
        JTextField indirizzo = new JTextField();
        JTextField nPorta = new JTextField();

        Object[] message = {
            "Indirizzo IP del server (default: 127.0.0.1):", indirizzo,
            "Numero di porta (default: 1050):", nPorta
        };

        int option = JOptionPane.showConfirmDialog(
            this,
            message,
            "Connessione al Server",
            JOptionPane.PLAIN_MESSAGE
        );

        String ip = "127.0.0.1";
        int port = 1050;

        if (option == JOptionPane.OK_OPTION) {
            if (!indirizzo.getText().trim().isEmpty()) {
                ip = indirizzo.getText().trim();
            }
            if (!nPorta.getText().trim().isEmpty()) {
                try {
                    port = Integer.parseInt(nPorta.getText().trim());
                    if (port < 1 || port > 65535) {
                        throw new NumberFormatException("Porta fuori intervallo (1-65535)");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Numero di porta non valido!", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            connessioneServer(ip, port);
        }
    }

    public void connessioneServer(String ip, int port) {
        try {
            Socket socket = new Socket(ip, port);
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            out.println("Connessione avvenuta con successo!");

            dispose();
            SwingUtilities.invokeLater(() -> {
                GUIClient guiClient = new GUIClient();
                guiClient.setOut(out);
                guiClient.setIn(in);
                guiClient.firstMessage();
                guiClient.setVisible(true);
            });
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Errore durante la connessione al server: " + e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}