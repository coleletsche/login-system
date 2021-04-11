package login;

import tools.Hash;
import tools.User;
import tools.UserFileReader;
import ui.LoginUI;

import java.util.ArrayList;

public class MainLogin {

    // Singleton design pattern
    public static MainLogin instance;

    private final UserFileReader reader;
    private ArrayList<User> users;

    public MainLogin() {
        instance = this;

        reader = new UserFileReader("users.txt");
        users = reader.getUsers();

        new LoginUI();
    }

    public boolean validateUser(User user) {
        for (User u : users)
            if (u.getUsername().equalsIgnoreCase(user.getUsername()) && u.getPassword().equals(Hash.md5(user.getPassword())))
                return true;
        return false;
    }

    public boolean doesUserExist(String username) {
        for (User user : users)
            if (user.getUsername().equalsIgnoreCase(username))
                return true;
        return false;
    }

    public static boolean validUsername(String username) {
        return username.length() >= 4 && username.length() <= 16 && !username.contains(" ");
    }

    public static boolean validPassword(String password) {
        return password.length() >= 4 && password.length() <= 16 && !password.contains(" ");
    }

    public void addUser(User user) {
        // Hash password and add user to list of users
        users.add(new User(user.getUsername(), Hash.md5(user.getPassword())));
        // Naively dump the whole users list to file
        reader.dumpToFile(users);
    }

    public static void main(String[] args) {
        new MainLogin();
    }
}
