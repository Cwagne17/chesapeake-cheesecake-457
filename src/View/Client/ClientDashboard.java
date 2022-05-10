package View.Client;

import Controller.ClientController;
import javax.swing.*;


public class ClientDashboard extends JPanel {
    private ClientController clientController;

    public ClientDashboard() {
        this.clientController = new ClientController(this);
    }

    public void getClients() {
        clientController.getClients();
    }

}

