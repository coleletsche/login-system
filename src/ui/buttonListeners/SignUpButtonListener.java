package ui.buttonListeners;

import ui.LoginUI;
import ui.SignUpUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpButtonListener implements ActionListener {

    private final LoginUI loginUI;

    public SignUpButtonListener(LoginUI loginUI) {
        this.loginUI = loginUI;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        loginUI.dispose();
        new SignUpUI();
    }
}
