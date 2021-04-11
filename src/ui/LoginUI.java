package ui;

import ui.buttonListeners.LoginButtonListener;
import ui.buttonListeners.SignUpButtonListener;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends UserInterface {

    private static final Dimension FRAME_DIMENSION = new Dimension(350, 190);

    public JTextField usernameText;
    public JPasswordField passwordText;

    public LoginUI() {
        super("Login", FRAME_DIMENSION, false, null, JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(15, 10, 80, 25);

        usernameText = new JTextField(30);
        usernameText.setBounds(90, 10, 250, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(15, 40, 80, 25);

        passwordText = new JPasswordField(30);
        passwordText.setEchoChar('\u2022');
        passwordText.setBounds(90, 40, 250, 25);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(15, 75, 320, 35);
        loginButton.addActionListener(new LoginButtonListener(this));

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(15, 115, 320, 35);
        signUpButton.addActionListener(new SignUpButtonListener(this));

        panel.add(usernameLabel);
        panel.add(usernameText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);
        panel.add(signUpButton);

        add(panel);

        revalidate();
        repaint();
    }
}
