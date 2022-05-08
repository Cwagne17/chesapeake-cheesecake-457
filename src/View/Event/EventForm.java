package View.Event;

import Config.errors.StringException;
import Controller.EventController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.UUID;

public class EventForm extends JPanel implements ActionListener {
    //Strings used to display information on form and send data to other parts of MVC

    private JLabel deliveryTime;
    private JLabel numGuests;
    private JLabel deliveryAddress;
    private JLabel allergies;
    private JLabel eventType;
    private JLabel venue;
    private JLabel budget;
    private JLabel clientEmail;
    private JLabel packageName;

    private JTextField deliveryTimeText;
    private JTextField numGuestsText;
    private JTextField deliveryAddressText;
    private JTextField allergiesText;
    private JTextField eventTypeText;
    private JTextField venueText;
    private JTextField budgetText;



    private JTextField clientEmailText;
    private JTextField packageNameText;

    private JButton eventButton;
    private EventController eventController = new EventController(this);

    public EventForm(String action) {

        deliveryTime = new JLabel("Delivery Time: ");
        numGuests = new JLabel("Guest Count: ");
        deliveryAddress = new JLabel("Email : ");
        allergies = new JLabel("Allergies: ");
        eventType = new JLabel("Event Type: ");
        budget = new JLabel("Budget: ");
        venue = new JLabel("Venue: ");

        deliveryTimeText = new JTextField(20);
        numGuestsText = new JTextField(20);
        deliveryAddressText = new JTextField(20);
        allergiesText = new JTextField(20);
        eventTypeText = new JTextField(20);


        if (action.equals("Create")) {
            eventButton = new JButton("Add Event");
            eventButton.setPreferredSize((new Dimension(200, 50)));
            eventButton.addActionListener(this);
        } else {
            System.out.println("Error: Not correct input for form.");
            System.exit(0);
        }

        setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        grid.insets = new Insets(1, 0, 1, 0);
        grid.weightx = 1;
        grid.weighty = 1;

        //Adding all the Jlabels
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridx = 0;
        grid.gridy = 0;
        add(deliveryTime, grid);

        grid.fill = GridBagConstraints.VERTICAL;
        grid.anchor = GridBagConstraints.EAST;

        grid.gridx = 0;
        grid.gridy = 1;
        add(numGuests, grid);

        grid.gridx = 0;
        grid.gridy = 2;
        add(deliveryAddress, grid);

        grid.gridx = 0;
        grid.gridy = 3;
        add(allergies, grid);

        grid.gridx = 0;
        grid.gridy = 4;
        add(eventType, grid);

        grid.gridx = 0;
        grid.gridy = 5;
        add(budget, grid);

        grid.gridx = 0;
        grid.gridy = 6;
        add(venue, grid);

        grid.gridx = 0;
        grid.gridy = 7;
        add(clientEmail, grid);

        grid.gridx = 0;
        grid.gridy = 8;
        add(packageName, grid);


        //Adding all the textfields
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.WEST;
        grid.gridx = 1;
        grid.gridy = 0;
        add(deliveryTimeText, grid);

        grid.gridx = 1;
        grid.gridy = 1;
        add(numGuests, grid);


        grid.gridx = 1;
        grid.gridy = 2;
        add(deliveryAddressText, grid);

        grid.gridx = 1;
        grid.gridy = 3;
        add(allergiesText, grid);

        grid.gridx = 1;
        grid.gridy = 4;
        add(eventTypeText, grid);

        grid.gridx = 1;
        grid.gridy = 5;
        add(budgetText, grid);

        grid.fill = GridBagConstraints.NONE;

        grid.gridwidth = 10;
        grid.gridx = 1;
        grid.gridy = 6;
        add(venueText, grid);

        grid.gridx = 1;
        grid.gridy = 7;
        add(clientEmailText, grid);

        grid.gridx = 1;
        grid.gridy = 8;
        add(packageNameText, grid);


        //generates button based on which action taken by user
        if (action.equals("Create")) {
            grid.gridwidth = 1;
            grid.gridheight = 1;
            grid.gridx = 1;
            grid.gridy = 11;
            add(eventButton, grid);
        }
    }

    //will be used to update and add clients
    //to be merged with client dashboard view
    public void actionPerformed(ActionEvent e) {
        //will create a new client, will be linked with model later
        if (eventButton.getText().equals("Add Event")) {
            try {
                eventController.submitEvent();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (StringException ex) {
                ex.printStackTrace();
            }
        }
    }

    //Getters

    public JTextField getDeliveryTimeText() {
        return deliveryTimeText;
    }

    public JTextField getNumGuestsText() {
        return numGuestsText;
    }

    public JTextField getAllergiesText() {
        return allergiesText;
    }

    public JTextField getEventTypeText() {
        return eventTypeText;
    }

    public JTextField getVenueText() {
        return venueText;
    }

    public JTextField getBudgetText() {
        return budgetText;
    }

    public JTextField getClientEmailText() {
        return clientEmailText;
    }

    public JTextField getPackageNameText() {
        return packageNameText;
    }

    public JTextField getDeliveryAddressText() {
        return deliveryAddressText;
    }


}

