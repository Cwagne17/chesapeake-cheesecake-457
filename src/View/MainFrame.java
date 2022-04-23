package View;

import View.Client.ClientDashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;

    public MainFrame() {
        super("Java Swing MVC");
        cardLayout = new CardLayout();
        Form form = new Form();
        TestForm testform = new TestForm();
        ClientDashboard clientDash = new ClientDashboard();
        JButton testButton = new JButton("Test Tab");
        JButton clientButton = new JButton("Client Tab");
        JPanel nav = new JPanel();

        nav.add(testButton);
        nav.add(clientButton);

        clientDash.add(nav);
        testform.add(nav);
        MainFrame.this.getContentPane().add(nav);

        setLayout(cardLayout);


        testButton.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     testform.add(clientButton);
                     MainFrame.this.setContentPane(testform);
                     MainFrame.this.invalidate();
                     MainFrame.this.validate();
                 }
                }
        );
        clientButton.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     clientDash.add(testButton);
                     MainFrame.this.setContentPane(clientDash);
                     MainFrame.this.invalidate();
                     MainFrame.this.validate();
                 }
             }
        );

        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}



