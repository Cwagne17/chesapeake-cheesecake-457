package View;

import View.Client.ClientDashboard;
import View.Client.ClientForm;
import View.Order.OrderDashboard;
import View.Order.OrderForm;

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

    public MainFrame() {
        super("Java Swing MVC");
        cardLayout = new CardLayout();

        mainMenu.add(clientTabButton);
        mainMenu.add(orderTabButton);


        MainFrame.this.getContentPane().add(mainMenu);

        setLayout(cardLayout);

        //Client Listeners


        clientTabButton.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {

                     clientDash.add(orderTabButton);
                     clientDash.add(clientUpdateButton);
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

        clientUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientFormUpdate.add(clientTabButton);
                MainFrame.this.setContentPane(clientFormUpdate);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

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
                orderDash.add(orderUpdateButton);
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

        orderUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderFormUpdate.add(orderTabButton);
                MainFrame.this.setContentPane(orderFormUpdate);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        viewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderDash.add(clientTabButton);
                orderDash.add(orderUpdateButton);
                orderDash.add(orderCreateButton);
                orderDash.add(viewOrderButton);
                orderDash.getOrders();
                MainFrame.this.setContentPane(orderDash);
                MainFrame.this.invalidate();
                MainFrame.this.validate();
            }
        });

        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}



