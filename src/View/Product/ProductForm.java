package View.Product;

//import Controller.PackageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductForm extends JPanel implements ActionListener {
    //Strings used to display information on form and send data to other parts of MVC

    private JLabel type;
    private JLabel flavor;
    private JLabel size;
    private JLabel stock;

    private JTextField typeText;
    private JTextField flavorText;
    private JTextField sizeText;
    private JTextField stockText;

    private JButton productButton;
    //private ProductController productController = new ProductController(this);

    public ProductForm(String action) {

        type = new JLabel("Package Type: ");
        flavor = new JLabel("Flavor: ");
        size = new JLabel("Size: ");
        stock = new JLabel("Stock: ");

        typeText = new JTextField(20);
        flavorText = new JTextField(20);
        sizeText = new JTextField(20);
        stockText = new JTextField(20);

        if (action.equals("Create")) {
            productButton = new JButton("Add Product");
            productButton.setPreferredSize((new Dimension(200, 50)));
            productButton.addActionListener(this);
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
        add(type, grid);

        grid.fill = GridBagConstraints.VERTICAL;
        grid.anchor = GridBagConstraints.EAST;

        grid.gridx = 0;
        grid.gridy = 1;
        add(flavor, grid);

        grid.gridx = 0;
        grid.gridy = 2;
        add(size, grid);

        grid.gridx = 0;
        grid.gridy = 3;
        add(stock, grid);

        //Adding all the textfields
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.WEST;
        grid.gridx = 1;
        grid.gridy = 0;
        add(typeText, grid);

        grid.gridx = 1;
        grid.gridy = 1;
        add(flavorText, grid);


        grid.gridx = 1;
        grid.gridy = 2;
        add(sizeText, grid);

        grid.gridx = 1;
        grid.gridy = 3;
        add(stockText, grid);

        //generates button based on which action taken by user
        if (action.equals("Create")) {
            grid.gridwidth = 1;
            grid.gridheight = 1;
            grid.gridx = 1;
            grid.gridy = 11;
            add(productButton, grid);
        }
    }

    //will be used to update and add clients
    //to be merged with client dashboard view
    public void actionPerformed(ActionEvent e) {
        //will create a new client, will be linked with model later
        if (productButton.getText().equals("Add Product")) {

            //productController.submitProduct();
        }

    }

    //Getters

    public JTextField getTypeText() {
        return typeText;
    }

    public JTextField getFlavorText() {
        return flavorText;
    }

    public JTextField getSizeText() {
        return sizeText;
    }

    public JTextField getStockText() {
        return stockText;
    }
}



