package View;

import View.Client.ClientDashboard;
import View.Client.ClientForm;
import View.Event.EventDashboard;
import View.Event.EventForm;
import View.Ingredient.IngredientDashboard;
import View.Ingredient.IngredientForm;
import View.Order.OrderDashboard;
import View.Order.OrderForm;
import View.Package.PackageDashboard;
import View.Package.PackageForm;
import View.Product.ProductDashboard;
import View.Product.ProductForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainMenu = new JPanel();

    //Client Panels
    private ClientForm clientFormCreate = new ClientForm("Create");
    private ClientForm clientFormUpdate = new ClientForm("Update");
    private ClientDashboard clientDash = new ClientDashboard();

    //Client Buttons
    private JButton clientCreateButton = new JButton("Create Client");
    //private JButton clientUpdateButton = new JButton("Client Update");
    private JButton viewClientButton = new JButton("View Clients");
    private JButton clientTabButton = new JButton("Client Tab");

    //Order Panels
    private OrderForm orderFormCreate = new OrderForm("Create");
    private OrderForm orderFormUpdate = new OrderForm("Update");
    private OrderDashboard orderDash = new OrderDashboard();

    //Order Buttons
    private JButton orderCreateButton = new JButton("Create Order");
   // private JButton orderUpdateButton = new JButton("Order Update");
    private JButton viewOrderButton = new JButton("View Orders");
    private JButton orderTabButton = new JButton("Order Tab");

    //Event Panels
    private EventForm eventFormCreate = new EventForm("Create");
    private EventDashboard eventDash = new EventDashboard();

    //Event Buttons
    private JButton eventCreateButton = new JButton("Create Event");
    private JButton viewEventButton = new JButton("View Events");
    private JButton eventTabButton = new JButton("Event Tab");

    //Ingredient Panels
    private IngredientForm ingredientFormCreate = new IngredientForm("Create");
    private IngredientDashboard ingredientDash = new IngredientDashboard();

    //Ingredient Buttons
    private JButton ingredientCreateButton = new JButton("Create Ingredient");
    private JButton viewIngredientButton = new JButton("View Ingredients");
    private JButton ingredientTabButton = new JButton("Ingredient Tab");

    //Package Panels
    private PackageForm packageFormCreate = new PackageForm("Create");
    private PackageDashboard packageDash = new PackageDashboard();

    //Package Buttons
    private JButton packageCreateButton = new JButton("Create Package");
    private JButton viewPackageButton = new JButton("View Packages");
    private JButton packageTabButton = new JButton("Package Tab");

    //Product Panels
    private ProductForm productFormCreate = new ProductForm("Create");
    private ProductDashboard productDash = new ProductDashboard();

    //Product Buttons
    private JButton productCreateButton = new JButton("Create Product");
    private JButton viewProductButton = new JButton("View Products");
    private JButton productTabButton = new JButton("Product Tab");

    public MainFrame() {
        super("Java Swing MVC");
        cardLayout = new CardLayout();

        mainMenu.add(clientTabButton);
        mainMenu.add(orderTabButton);
        mainMenu.add(productTabButton);
        mainMenu.add(ingredientTabButton);
        mainMenu.add(eventTabButton);
        mainMenu.add(packageTabButton);

        MainFrame.this.getContentPane().add(mainMenu);

        setLayout(cardLayout);

        //Client Listeners

        clientTabButton.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {

                     clientDash.add(eventTabButton);
                     clientDash.add(ingredientTabButton);
                     clientDash.add(orderTabButton);
                     clientDash.add(packageTabButton);
                     clientDash.add(productTabButton);

                     clientDash.add(clientCreateButton);
                     clientDash.add(viewClientButton);

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

        viewClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientDash.add(eventTabButton);
                clientDash.add(ingredientTabButton);
                clientDash.add(orderTabButton);
                clientDash.add(packageTabButton);
                clientDash.add(productTabButton);

                clientDash.add(clientCreateButton);
                clientDash.add(viewClientButton);
                clientDash.getClients();
                MainFrame.this.setContentPane(clientDash);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        //Order Listeners

        orderTabButton.addActionListener(e -> {
                orderDash.add(clientTabButton);
                orderDash.add(eventTabButton);
                orderDash.add(ingredientTabButton);
                orderDash.add(packageTabButton);
                orderDash.add(productTabButton);

                orderDash.add(orderCreateButton);
                orderDash.add(viewOrderButton);
                MainFrame.this.setContentPane(orderDash);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        );

        orderCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderFormCreate.add(orderTabButton);
                MainFrame.this.setContentPane(orderFormCreate);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        viewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderDash.add(clientTabButton);
                orderDash.add(eventTabButton);
                orderDash.add(ingredientTabButton);
                orderDash.add(packageTabButton);
                orderDash.add(productTabButton);

                orderDash.add(orderCreateButton);
                orderDash.add(viewOrderButton);
                orderDash.getOrders();
                MainFrame.this.setContentPane(orderDash);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        //Event Listeners

        eventTabButton.addActionListener(e -> {
                eventDash.add(clientTabButton);
                eventDash.add(ingredientTabButton);
                eventDash.add(orderTabButton);
                eventDash.add(packageTabButton);
                eventDash.add(productTabButton);

                eventDash.add(eventCreateButton);
                eventDash.add(viewEventButton);

                MainFrame.this.setContentPane(eventDash);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        );


        eventCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventFormCreate.add(eventTabButton);
                MainFrame.this.setContentPane(eventFormCreate);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        viewEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventDash.add(clientTabButton);
                eventDash.add(ingredientTabButton);
                eventDash.add(orderTabButton);
                eventDash.add(packageTabButton);
                eventDash.add(productTabButton);

                eventDash.add(eventCreateButton);
                eventDash.add(viewEventButton);
                eventDash.getEvents();
                MainFrame.this.setContentPane(eventDash);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        //Package Listeners
        packageTabButton.addActionListener(e -> {
                    packageDash.add(clientTabButton);
                    packageDash.add(eventTabButton);
                    packageDash.add(ingredientTabButton);
                    packageDash.add(orderTabButton);
                    packageDash.add(productTabButton);

                    packageDash.add(packageCreateButton);
                    packageDash.add(viewPackageButton);

                    MainFrame.this.setContentPane(packageDash);
                    MainFrame.this.invalidate();
                    MainFrame.this.validate();
                }
        );

        packageCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                packageFormCreate.add(packageTabButton);
                MainFrame.this.setContentPane(packageFormCreate);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        viewPackageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                packageDash.add(clientTabButton);
                packageDash.add(eventTabButton);
                packageDash.add(ingredientTabButton);
                packageDash.add(orderTabButton);
                packageDash.add(productTabButton);

                packageDash.add(packageCreateButton);
                packageDash.add(viewPackageButton);
                packageDash.getPackages();
                MainFrame.this.setContentPane(packageDash);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        //Product Listeners
        productTabButton.addActionListener(e -> {
                    productDash.add(clientTabButton);
                    productDash.add(eventTabButton);
                    productDash.add(ingredientTabButton);
                    productDash.add(orderTabButton);
                    productDash.add(packageTabButton);

                    productDash.add(productCreateButton);
                    productDash.add(viewProductButton);
                    MainFrame.this.setContentPane(productDash);
                    MainFrame.this.invalidate();
                    MainFrame.this.validate();
                }
        );

        productCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productFormCreate.add(productTabButton);
                MainFrame.this.setContentPane(productFormCreate);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        viewProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productDash.add(clientTabButton);
                productDash.add(eventTabButton);
                productDash.add(ingredientTabButton);
                productDash.add(orderTabButton);
                productDash.add(packageTabButton);

                productDash.add(productCreateButton);
                productDash.add(viewProductButton);
                productDash.getProducts();
                MainFrame.this.setContentPane(productDash);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        //Ingredient Listeners
        ingredientTabButton.addActionListener(e -> {
            ingredientDash.add(clientTabButton);
            ingredientDash.add(eventTabButton);
            ingredientDash.add(orderTabButton);
            ingredientDash.add(packageTabButton);
            ingredientDash.add(productTabButton);

            ingredientDash.add(ingredientCreateButton);
            ingredientDash.add(viewIngredientButton);
            MainFrame.this.setContentPane(ingredientDash);
            MainFrame.this.invalidate();
            MainFrame.this.validate();
        }
        );

        ingredientCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientFormCreate.add(ingredientTabButton);
                MainFrame.this.setContentPane(ingredientFormCreate);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        viewIngredientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientDash.add(clientTabButton);
                ingredientDash.add(eventTabButton);
                ingredientDash.add(orderTabButton);
                ingredientDash.add(packageTabButton);
                ingredientDash.add(productTabButton);

                ingredientDash.add(ingredientCreateButton);
                ingredientDash.add(viewIngredientButton);
                ingredientDash.getIngredients();
                MainFrame.this.setContentPane(ingredientDash);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });


        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}



