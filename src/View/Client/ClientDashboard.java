package View.Client;

import Controller.ClientController;
import View.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientDashboard extends JPanel {
    private JButton testFormButton;
    private ClientController clientController = new ClientController(this);

    public ClientDashboard() {
        add(testFormButton);
    }

    public void getClients() {
        clientController.getClients();
    }


}

