package ui.buttonListeners;

import login.MainLogin;
import tools.User;
import ui.NotifyUserUI;
import ui.SignUpUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewSignUpButtonListener implements ActionListener {

    private final SignUpUI signUpUI;

    public NewSignUpButtonListener(SignUpUI signUpUI) {
        this.signUpUI = signUpUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = signUpUI.usernameText.getText();
        String password = new String(signUpUI.passwordText.getPassword());
        String reEnter = new String(signUpUI.reEnterText.getPassword());

        if (username.length() == 0 || password.length() == 0 || reEnter.length() == 0) {
            new NotifyUserUI("Enter All Fields!", Color.RED);
            return;
        }

        if (MainLogin.instance.doesUserExist(username)) {
            new NotifyUserUI("Username Already Exists!", Color.RED);
            return;
        }

        if (!MainLogin.validUsername(username)) {
            new NotifyUserUI("Invalid Username!", Color.RED);
            return;
        }

        if (!MainLogin.validPassword(password)) {
            new NotifyUserUI("Invalid Password!", Color.RED);
            return;
        }

        if (!password.equals(reEnter)) {
            new NotifyUserUI("Passwords Don't Match!", Color.RED);
            return;
        }

        MainLogin.instance.addUser(new User(username, password));
        new NotifyUserUI("User Added!", Color.GREEN);
    }
}
