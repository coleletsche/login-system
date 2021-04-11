package ui;

import javax.swing.*;
import java.awt.*;

public abstract class UserInterface extends JFrame {

    public UserInterface instance;

    public UserInterface(String title, Dimension size, boolean resizable, Component locationRelativeTo, int closeOperation) {
        super(title);

        instance = this;

        setSize(size);

        if (resizable)
            setResizable(true);
        else {
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
        }

        setLocationRelativeTo(locationRelativeTo);
        setDefaultCloseOperation(closeOperation);
        setVisible(true);
    }
}
