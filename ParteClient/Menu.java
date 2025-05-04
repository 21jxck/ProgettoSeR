import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    public Menu() {
        super("Menu Principale");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel titolo = new JLabel("STRUTTURE RICETTIVE REGIONE VENETO", SwingConstants.CENTER);
        titolo.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 35));
        add(titolo, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100,150,25,150));

        JButton connetti = new JButton("Connetti");
        connetti.setPreferredSize(new Dimension(300, 50));
        connetti.setMaximumSize(new Dimension(300, 50));

        connetti.setBackground(Color.CYAN);
        connetti.setForeground(Color.BLACK);

        connetti.addActionListener(click -> connessione());
        connetti.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton esci = new JButton("Esci");
        esci.setPreferredSize(new Dimension(200, 50));
        esci.setMaximumSize(new Dimension(200, 50));

        esci.setBackground(Color.GRAY);
        esci.setForeground(Color.WHITE);

        esci.addActionListener(click -> System.exit(0));
        esci.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonPanel.add(connetti);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,50)));
        buttonPanel.add(esci);

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void connessione() {
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
        String port = "1050";

        if (option == JOptionPane.OK_OPTION) {
            if (!indirizzo.getText().trim().isEmpty()) {
                ip = indirizzo.getText().trim();
            }
            if (!nPorta.getText().trim().isEmpty()) {
                port = nPorta.getText().trim();
            }
            // da qui continuo
            try {
                int portNumber = Integer.parseInt(port);
                JOptionPane.showMessageDialog(this, "Connessione a " + ip + " sulla porta " + portNumber);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Numero di porta non valido!", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}