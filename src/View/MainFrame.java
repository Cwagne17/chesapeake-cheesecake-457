package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;

    public MainFrame() {
        super("Java Swing MVC");
        cardLayout = new CardLayout();
        Form form = new Form();

        setLayout(cardLayout);

        add(form,"form");

        cardLayout.show(MainFrame.this.getContentPane(), "form");

        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
