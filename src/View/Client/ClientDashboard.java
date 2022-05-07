package View.Client;

import Controller.ClientController;
import javax.swing.*;


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

