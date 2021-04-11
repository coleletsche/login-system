package ui;

import ui.buttonListeners.BackToLoginButtonListener;
import ui.buttonListeners.NewSignUpButtonListener;

import javax.swing.*;
import java.awt.*;

public class SignUpUI extends UserInterface {

    private static final Dimension FRAME_DIMENSION = new Dimension(350, 220);

    public JTextField usernameText;
    public JPasswordField passwordText;
    public JPasswordField reEnterText;

    public SignUpUI() {
        super("Sign Up", FRAME_DIMENSION, false, null, JFrame.EXIT_ON_CLOSE);

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

        JLabel reEnterLabel = new JLabel("Re-Enter:");
        reEnterLabel.setBounds(15, 70, 80, 25);

        reEnterText = new JPasswordField(30);
        reEnterText.setEchoChar('\u2022');
        reEnterText.setBounds(90, 70, 250, 25);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(15, 105, 320, 35);
        signUpButton.addActionListener(new NewSignUpButtonListener(this));

        JButton backToLogin = new JButton("Back To Login");
        backToLogin.setBounds(15, 140, 320, 35);
        backToLogin.addActionListener(new BackToLoginButtonListener(this));

        panel.add(usernameLabel);
        panel.add(usernameText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(reEnterLabel);
        panel.add(reEnterText);
        panel.add(signUpButton);
        panel.add(backToLogin);

        add(panel);

        revalidate();
        repaint();
    }
}
