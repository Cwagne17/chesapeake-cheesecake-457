package View.Client;

import View.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientDashboard extends JPanel {
    private JTextArea textArea1;
    private JButton viewClientButton;
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;
    private JList list5;
    private JButton testFormButton;


    public ClientDashboard() {

        add(textArea1);
        add(viewClientButton);
        add(list1);
        add(list2);
        add(list3);
        add(list4);
        add(list5);
        add(testFormButton);
    }

    public void viewClients(ActionListener actionListener) {
        viewClientButton.addActionListener(actionListener);
    }
}

