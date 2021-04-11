package tools;

import tools.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserFileReader {

    private ArrayList<User> users;
    private final String userFileName;

    public UserFileReader(String userFileName) {
        users = new ArrayList<User>();
        this.userFileName = userFileName;

        try {
            BufferedReader in = new BufferedReader(new FileReader(userFileName));

            int numUsers = Integer.parseInt(in.readLine());

            for (int i = 0; i < numUsers; i++) {
                String username = in.readLine();
                String password = in.readLine();

                users.add(new User(username, password));
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dumpToFile(ArrayList<User> users) {
        try {
            FileWriter writer = new FileWriter(userFileName);

            writer.write(users.size() + "\n");

            for (User user : users) {
                writer.write(user.getUsername() + "\n");
                writer.write(user.getPassword() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("[Error] Writing users to file!");
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
