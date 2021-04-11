package ui.buttonListeners;

import ui.LoginUI;
import ui.SignUpUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackToLoginButtonListener implements ActionListener {

    private final SignUpUI signUpUI;

    public BackToLoginButtonListener(SignUpUI signUpUI) {
        this.signUpUI = signUpUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        signUpUI.dispose();
        new LoginUI();
    }
}
