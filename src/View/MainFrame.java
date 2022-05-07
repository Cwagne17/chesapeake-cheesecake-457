package View;

import View.Client.ClientDashboard;
import View.Client.ClientForm;

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
        ClientDashboard clientDash = new ClientDashboard();

        JButton testButton = new JButton("Test Tab");
        JButton clientTabButton = new JButton("Client Tab");

        ClientForm clientFormUpdate = new ClientForm("Update");
        ClientForm clientFormRead = new ClientForm("Read");
        ClientForm clientFormCreate = new ClientForm("Create");
        JButton clientUpdateButton = new JButton("Client Update");

        JButton clientReadButton = new JButton("Client Read");
        JButton clientCreateButton = new JButton("Client Create");


        JPanel clientNav = new JPanel();
        JPanel testNav = new JPanel();

        clientNav.add(clientUpdateButton);
        clientNav.add(clientReadButton);
        clientNav.add(clientCreateButton);

        testNav.add(clientTabButton);

        clientDash.add(clientNav);
        form.add(testNav);

        MainFrame.this.getContentPane().add(testNav);
        MainFrame.this.getContentPane().add(clientNav);

        setLayout(cardLayout);

        testButton.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     form.add(clientTabButton);
                     MainFrame.this.setContentPane(form);
                     MainFrame.this.invalidate();
                     MainFrame.this.validate();
                 }
                }
        );

        clientTabButton.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     clientDash.add(testButton);
                     clientDash.add(clientUpdateButton);
                     clientDash.add(clientReadButton);
                     clientDash.add(clientCreateButton);
                     MainFrame.this.setContentPane(clientDash);
                     MainFrame.this.invalidate();
                     MainFrame.this.validate();
                 }
             }
        );

        clientCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientFormCreate.add(clientTabButton);
                MainFrame.this.setContentPane(clientFormCreate);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        clientUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientFormUpdate.add(clientTabButton);
                MainFrame.this.setContentPane(clientFormUpdate);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        clientReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientFormRead.add(clientTabButton);
                MainFrame.this.setContentPane(clientFormRead);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}



