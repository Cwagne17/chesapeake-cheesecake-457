package View;

import View.Client.ClientDashboard;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;

    public MainFrame() {
        super("Java Swing MVC");
        cardLayout = new CardLayout();
        Form form = new Form();
        TestForm testform = new TestForm();
        ClientDashboard clientDash = new ClientDashboard();

        setLayout(cardLayout);

        add(form,"form");
        add(testform, "test");


        cardLayout.show(MainFrame.this.getContentPane(), "test");

        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
