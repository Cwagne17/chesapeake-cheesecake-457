package View.Package;


//import Controller.PackageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PackageForm extends JPanel implements ActionListener {
    //Strings used to display information on form and send data to other parts of MVC

    private JLabel nameLabel;
    private JLabel costLabel;

    private JTextField nameText;
    private JTextField costText;

    private JButton packageButton;
    //private PackageController packageController = new packageController(this);

    public PackageForm(String action) {

        nameLabel = new JLabel("Package Name: ");
        costLabel = new JLabel("Cost: ");

        costText = new JTextField(20);
        nameText = new JTextField(20);


        if (action.equals("Create")) {
            packageButton = new JButton("Add Ingredient");
            packageButton.setPreferredSize((new Dimension(200, 50)));
            packageButton.addActionListener(this);
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
        add(nameLabel, grid);

        grid.fill = GridBagConstraints.VERTICAL;
        grid.anchor = GridBagConstraints.EAST;

        grid.gridx = 0;
        grid.gridy = 1;
        add(costLabel, grid);

        //Adding all the textfields
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.WEST;
        grid.gridx = 1;
        grid.gridy = 0;
        add(nameText, grid);

        grid.gridx = 1;
        grid.gridy = 1;
        add(costText, grid);

        //generates button based on which action taken by user
        if (action.equals("Create")) {
            grid.gridwidth = 1;
            grid.gridheight = 1;
            grid.gridx = 1;
            grid.gridy = 11;
            add(packageButton, grid);
        }
    }

    //will be used to update and add clients
    //to be merged with client dashboard view
    public void actionPerformed(ActionEvent e) {
        //will create a new client, will be linked with model later
        if (packageButton.getText().equals("Add Ingredient")) {

            //packageController.submitPackage();
        }

    }

    //Getters
    public JTextField getNameText() {
        return nameText;
    }

    public JTextField getCostText() {
        return costText;
    }
}
