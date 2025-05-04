import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    public Menu() {
        super("Menu Principale");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0);

        JLabel titolo = new JLabel("STRUTTURE RICETTIVE REGIONE VENETO", SwingConstants.CENTER);
        titolo.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(titolo, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton connectButton = new JButton("Connetti");
        connectButton.setPreferredSize(new Dimension(150, 50));
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Menu.this, "Connessione in corso...");
            }
        });

        JButton exitButton = new JButton("Esci");
        exitButton.setPreferredSize(new Dimension(150, 50));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(connectButton);
        buttonPanel.add(exitButton);

        gbc.gridy = 1;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}