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
    private JButton clientCreateButton = new JButton("Client Create");
    private JButton clientUpdateButton = new JButton("Client Update");
    private JButton viewClientButton = new JButton("View Clients");
    private JButton clientTabButton = new JButton("Client Tab");

    //Order Panels
    private OrderForm orderFormCreate = new OrderForm("Create");
    private OrderForm orderFormUpdate = new OrderForm("Update");
    private OrderDashboard orderDash = new OrderDashboard();

    //Order Buttons
    private JButton orderCreateButton = new JButton("Order Create");
    private JButton orderUpdateButton = new JButton("Order Update");
    private JButton viewOrderButton = new JButton("View Orders");
    private JButton orderTabButton = new JButton("Order Tab");

    //Event Panels
    private EventForm eventFormCreate = new EventForm("Create");
    private EventDashboard eventDash = new EventDashboard();

    //Event Buttons
    private JButton eventCreateButton = new JButton("Event Create");
    private JButton viewEventButton = new JButton("View Orders");
    private JButton eventTabButton = new JButton("Event Tab");

    //Ingredient Panels
    private IngredientForm ingredientFormCreate = new IngredientForm("Create");
    private IngredientDashboard ingredientDash = new IngredientDashboard();

    //Ingredient Buttons
    private JButton ingredientCreateButton = new JButton("Ingredient Create");
    private JButton viewIngredientButton = new JButton("View Ingredients");
    private JButton ingredientTabButton = new JButton("Ingredient Tab");

    //Package Panels
    private PackageForm packageFormCreate = new PackageForm("Create");
    private PackageDashboard packageDash = new PackageDashboard();

    //Package Buttons
    private JButton packageCreateButton = new JButton("Package Create");
    private JButton viewPackageButton = new JButton("View Packages");
    private JButton packageTabButton = new JButton("Package Tab");

    //Product Panels
    private ProductForm productFormCreate = new ProductForm("Create");
    private ProductDashboard productDash = new ProductDashboard();

    //Product Buttons
    private JButton productCreateButton = new JButton("Product Create");
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

                     clientDash.add(mainMenu);
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

//        clientUpdateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                clientFormUpdate.add(clientTabButton);
//                MainFrame.this.setContentPane(clientFormUpdate);
//                MainFrame.this.invalidate();
//                MainFrame.this.validate();
//            }
//        });

        viewClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientDash.add(orderTabButton);
                clientDash.add(clientUpdateButton);
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

//        orderUpdateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                orderFormUpdate.add(orderTabButton);
//                MainFrame.this.setContentPane(orderFormUpdate);
//                MainFrame.this.invalidate();
//                MainFrame.this.validate();
//            }
//        });

        viewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderDash.add(mainMenu);
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
                    eventDash.add(mainMenu);
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
                eventDash.add(mainMenu);
                eventDash.add(eventCreateButton);
                eventDash.add(viewEventButton);
                eventDash.getEvents();
                MainFrame.this.setContentPane(orderDash);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        //Package Listeners
        packageTabButton.addActionListener(e -> {
                    packageDash.add(mainMenu);
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
                packageDash.add(mainMenu);
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
                    productDash.add(mainMenu);
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
                productDash.add(mainMenu);
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
                    ingredientDash.add(mainMenu);
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
                ingredientDash.add(mainMenu);
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



