package ui.buttonListeners;

import login.MainLogin;
import tools.Hash;
import ui.LoginUI;
import ui.NotifyUserUI;
import tools.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonListener implements ActionListener {

    private final LoginUI loginUI;

    public LoginButtonListener(LoginUI loginUI) {
        this.loginUI = loginUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = loginUI.usernameText.getText();
        String password = new String(loginUI.passwordText.getPassword());

        if (username.length() == 0 || password.length() == 0) {
            new NotifyUserUI("Enter All Fields!", Color.RED);
            return;
        }

        User user = new User(username, password);
        if (MainLogin.instance.validateUser(user)) {
            new NotifyUserUI("Login Successful!", Color.GREEN);
        } else {
            new NotifyUserUI("Login Unsuccessful!", Color.RED);
        }
    }
}
