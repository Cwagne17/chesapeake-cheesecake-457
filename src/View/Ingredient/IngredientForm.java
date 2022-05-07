package View.Ingredient;

//import Controller.IngredientController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngredientForm extends JPanel implements ActionListener {
    //Strings used to display information on form and send data to other parts of MVC

    private JLabel nameLabel;
    private JLabel stockLabel;

    private JTextField nameText;
    private JTextField stockText;


    private JButton ingButton;
    //private IngredientController ingredientController = new ingredientController(this);

    public IngredientForm(String action) {

        nameLabel = new JLabel("Ingredient Name: ");
        stockLabel = new JLabel("Stock Count: ");

        stockText = new JTextField(20);
        nameText = new JTextField(20);


        if (action.equals("Create")) {
            ingButton = new JButton("Add Ingredient");
            ingButton.setPreferredSize((new Dimension(200, 50)));
            ingButton.addActionListener(this);
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
        add(stockLabel, grid);

        //Adding all the textfields
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.WEST;
        grid.gridx = 1;
        grid.gridy = 0;
        add(nameText, grid);

        grid.gridx = 1;
        grid.gridy = 1;
        add(stockText, grid);

        //generates button based on which action taken by user
        if (action.equals("Create")) {
            grid.gridwidth = 1;
            grid.gridheight = 1;
            grid.gridx = 1;
            grid.gridy = 11;
            add(ingButton, grid);
        }
    }

    //will be used to update and add clients
    //to be merged with client dashboard view
    public void actionPerformed(ActionEvent e) {
        //will create a new client, will be linked with model later
        if (ingButton.getText().equals("Add Ingredient")) {
            //add the uuid with least significant bits removed that arent needed within this method
            //ingredientController.submitIngredient();
        }

    }

    //Getters

    public JTextField getNameText() {
        return nameText;
    }

    public JTextField getStockText() {
        return stockText;
    }

}