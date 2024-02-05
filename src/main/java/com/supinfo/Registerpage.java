package com.supinfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registerpage extends JFrame {

    private JTextField newUsernameField;
    private JPasswordField newPasswordField;

    public Registerpage() {
        super("Register page");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel newUsernameLabel = new JLabel("New Username:");
        newUsernameField = new JTextField();
        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordField = new JPasswordField();
        JButton registerButton = new JButton("Register");

        panel.add(newUsernameLabel);
        panel.add(newUsernameField);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = newUsernameField.getText();
                char[] newPasswordChars = newPasswordField.getPassword();
                String newPassword = new String(newPasswordChars);

                JOptionPane.showMessageDialog(null, "User registered successfully!");
                dispose();
            }
        });

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Registerpage();
            }
        });
    }
}
