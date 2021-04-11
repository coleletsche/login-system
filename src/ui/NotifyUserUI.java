package ui;

import javax.swing.*;
import java.awt.*;

public class NotifyUserUI extends UserInterface {

    private static final Dimension FRAME_DIMENSION = new Dimension(350, 150);

    private final String message;
    private final Color colour;

    public NotifyUserUI(String message, Color colour) {
        super("", FRAME_DIMENSION, false, null, JFrame.DISPOSE_ON_CLOSE);

        this.message = message;
        this.colour = colour;

        initComponents();
    }

    private void initComponents() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel label = new JLabel(message);
        label.setForeground(colour);
        label.setFont(new Font("Dialog", Font.BOLD, 20));

        panel.add(label);

        add(panel);

        revalidate();
        repaint();
    }
}
