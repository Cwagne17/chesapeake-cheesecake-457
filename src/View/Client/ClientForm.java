package View.Client;
import Controller.ClientController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClientForm extends JPanel implements ActionListener {
    //Strings used to display information on form and send data to other parts of MVC
    private String name;
    private String name1;
    private String name2;
    private String email;
    private String address;
    private String phone;
    private String preferred;
    private int individual;
    private JPanel panelFormMain;
    private JLabel clientDetails;
    private JLabel clientName;
    private JLabel clientEmail;
    private JLabel clientPhone;
    private JLabel clientContact;
    private JLabel clientAddress;
    private JLabel clientCity;
    private JLabel clientState;
    private JLabel clientZIP;
    private JLabel clientType;
    private JTextField nameText;
    private JTextField emailText;
    private JTextField phoneText;
    private JTextField contactText;
    private JTextField addressText;
    private JTextField cityText;
    private JTextField stateText;
    private JTextField zipText;
    private JTextField typeText;
    private JButton clientButton;
    private ClientController clientController = new ClientController(this);

    public ClientForm(String action) {

        clientDetails = new JLabel("    Client Details");
        clientName = new JLabel("Client Name: ");
        clientEmail = new JLabel("Email : ");
        clientPhone = new JLabel("Phone Number: ");
        clientContact = new JLabel("Preferred Contact: ");
        clientAddress = new JLabel("Address: ");
        clientCity = new JLabel("City: ");
        clientState = new JLabel("State: ");
        clientZIP = new JLabel("ZIP: ");
        clientType = new JLabel("Type: ");

        nameText = new JTextField(20);
        emailText = new JTextField(20);
        phoneText = new JTextField(20);
        contactText = new JTextField(20);
        addressText = new JTextField(20);
        cityText = new JTextField(12);
        stateText = new JTextField(4);
        zipText = new JTextField(10);
        typeText = new JTextField(15);

        //read form allows for updating the client information
        if(action.equals("Read")) {
            //change setText values while connecting view forms to client model
            nameText.setText("name");
            nameText.setEditable(false);
            emailText.setText("1234@email.com");
            emailText.setEditable(false);
            phoneText.setText("111-111-1111");
            phoneText.setEditable(false);
            contactText.setText("Phone");
            contactText.setEditable(false);
            addressText.setText("1234 St.");
            addressText.setEditable(false);
            cityText.setText("Baltimore");
            cityText.setEditable(false);
            stateText.setText("MD");
            stateText.setEditable(false);
            zipText.setText("11111");
            zipText.setEditable(false);
            typeText.setText("Individual");
            typeText.setEditable(false);
            clientButton = new JButton("Update Client");
            clientButton.setPreferredSize((new Dimension(200, 50)));
            clientButton.addActionListener(this);
        }
        else if(action.equals("Create")) {
            clientButton = new JButton("Add Client");
            clientButton.setPreferredSize((new Dimension(200, 50)));
            clientButton.addActionListener(this);
        }
        else if(action.equals("Update")){
            // allows user to update info on client, will be connected to model later
            nameText.setText("name");
            emailText.setText("1234@email.com");
            phoneText.setText("111-111-1111");
            contactText.setText("Phone");
            addressText.setText("1234 St.");
            cityText.setText("Baltimore");
            stateText.setText("MD");
            zipText.setText("11111");
            typeText.setText("Individual");
            clientButton = new JButton("Update");
            clientButton.setPreferredSize((new Dimension(200, 50)));
            clientButton.addActionListener(this);
        }
        else {
            System.out.println("Error: Not correct input for form.");
            System.exit(0);
        }
        setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        grid.insets = new Insets(1, 0,1,0);
        grid.weightx = 1;
        grid.weighty = 1;

        //Adding all the Jlabels
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridx = 0;
        grid.gridy = 0;
        add(clientDetails, grid);

        grid.fill = GridBagConstraints.VERTICAL;
        grid.anchor = GridBagConstraints.EAST;

        grid.gridx = 0;
        grid.gridy = 2;
        add(clientName, grid);

        grid.gridx = 0;
        grid.gridy = 3;
        add(clientEmail, grid);

        grid.gridx = 0;
        grid.gridy = 4;
        add(clientPhone,grid);

        grid.gridx = 0;
        grid.gridy = 5;
        add(clientContact, grid);

        grid.gridx = 0;
        grid.gridy = 6;
        add(clientAddress,grid);

        grid.gridx = 0;
        grid.gridy = 7;
        add(clientCity, grid);

        grid.anchor = GridBagConstraints.EAST;
        grid.gridx = 1;
        grid.gridy = 7;
        add(clientState,grid);

        grid.anchor = GridBagConstraints.EAST;
        grid.fill = GridBagConstraints.VERTICAL;
        grid.gridx = 0;
        grid.gridy = 8;
        add(clientZIP,grid);

        grid.gridx = 0;
        grid.gridy = 9;
        add(clientType, grid);

        //Adding all the textfields
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.WEST;
        grid.gridx = 1;
        grid.gridy = 2;
        add(nameText, grid);

        grid.gridx = 1;
        grid.gridy = 3;
        add(emailText, grid);

        grid.gridx = 1;
        grid.gridy = 4;
        add(phoneText, grid);

        grid.gridx = 1;
        grid.gridy = 5;
        add(contactText, grid);

        grid.gridx = 1;
        grid.gridy = 6;
        add(addressText, grid);

        grid.fill = GridBagConstraints.NONE;
        grid.gridwidth = 10;
        grid.gridx = 1;
        grid.gridy = 7;
        add(cityText,grid);

        grid.anchor = GridBagConstraints.WEST;
        grid.gridx = 2;
        grid.gridy = 7;
        add(stateText,grid);

        grid.gridwidth = 1;
        grid.gridx = 1;
        grid.gridy = 8;
        add(zipText,grid);

        grid.gridx = 1;
        grid.gridy = 9;
        add(typeText, grid);

        //generates button based on which action taken by user
        if(action.equals("Create")) {
            grid.gridwidth = 1;
            grid.gridheight = 1;
            grid.gridx = 1;
            grid.gridy = 11;
            add(clientButton, grid);
        } else if (action.equals("Update") || action.equals("Read")) {
            grid.gridwidth = 1;
            grid.gridheight = 1;
            grid.gridx = 1;
            grid.gridy = 11;
            add(clientButton, grid);
        }
    }
    //will be used to update and add clients
    //to be merged with client dashboard view
    public void actionPerformed(ActionEvent e)
    {
        //will create a new client, will be linked with model later
        if(clientButton.getText().equals("Add Client")){
            clientController.submitClient();
        }
        //when in read form and user clicks "Update Client"
        //sets each value to editable and once model is connected allows user to update info
        else if(clientButton.getText().equals("Update Client")) {
            nameText.setEditable(true);
            emailText.setEditable(true);
            phoneText.setEditable(true);
            contactText.setEditable(true);
            addressText.setEditable(true);
            cityText.setEditable(true);
            stateText.setEditable(true);
            zipText.setEditable(true);
            typeText.setEditable(true);
            clientButton.setText("Update");

        } else if(clientButton.getText().equals("Update")) {
            //will allow user to change the information of the record once form is connected to model
            //values set to non editable after update
            nameText.setText("Tim");
            emailText.setText("1234@email.com");
            phoneText.setText("111-111-1111");
            contactText.setText("Phone");
            addressText.setText("1234 St.");
            cityText.setText("Baltimore");
            stateText.setText("MD");
            zipText.setText("11111");
            typeText.setText("Individual");
            clientButton.setText("Update Client");
            nameText.setEditable(false);
            emailText.setEditable(false);
            phoneText.setEditable(false);
            contactText.setEditable(false);
            addressText.setEditable(false);
            cityText.setEditable(false);
            stateText.setEditable(false);
            zipText.setEditable(false);
            typeText.setEditable(false);
        }

    }
    //Getters
    public JPanel getPanelFormMain() {
        return panelFormMain;
    }

    public JLabel getClientDetails() {
        return clientDetails;
    }

    public JLabel getClientName() {
        return clientName;
    }

    public JLabel getClientEmail() {
        return clientEmail;
    }

    public JLabel getClientPhone() {
        return clientPhone;
    }

    public JLabel getClientContact() {
        return clientContact;
    }

    public JLabel getClientAddress() {
        return clientAddress;
    }

    public JLabel getClientCity() {
        return clientCity;
    }

    public JLabel getClientState() {
        return clientState;
    }

    public JLabel getClientZIP() {
        return clientZIP;
    }

    public JLabel getClientType() {
        return clientType;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public JTextField getEmailText() {
        return emailText;
    }

    public JTextField getPhoneText() {
        return phoneText;
    }

    public JTextField getContactText() {
        return contactText;
    }

    public JTextField getAddressText() {
        return addressText;
    }

    public JTextField getCityText() {
        return cityText;
    }

    public JTextField getStateText() {
        return stateText;
    }

    public JTextField getZipText() {
        return zipText;
    }

    public JTextField getTypeText() {
        return typeText;
    }
    public JButton getClientCreate() {
        return clientButton;
    }

}

