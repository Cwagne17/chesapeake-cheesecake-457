package View.Order;
import Controller.OrderController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OrderForm extends JPanel implements ActionListener {

    private String products;
    private String clientEmail;
    private String orderTime;
    private String paidDate;
    private String payType;
    private String deliveryAdd;
    private String deliveryTime;

    private JLabel orderDetails;
    private JLabel orderProduct;
    private JLabel orderEmail;
    private JLabel orderT;
    private JLabel orderPaid;
    private JLabel orderPayT;
    private JLabel orderAdd;
    private JLabel orderDelTime;
    private JTextField productText;
    private JTextField emailText;
    private JTextField oTimeText;
    private JTextField pdText;
    private JTextField ptText;
    private JTextField delAddText;
    private JTextField delTimeText;
    private JButton orderButton;

    private OrderController orderController = new OrderController(this);

    public OrderForm(String o){

        orderDetails = new JLabel("     Order Details");
        orderProduct = new JLabel("Product: ");
        orderEmail = new JLabel("Client Email: ");
        orderT = new JLabel("Order Time: ");
        orderPaid = new JLabel("Paid Date: ");
        orderPayT = new JLabel("Payment Type: ");
        orderAdd = new JLabel("Delivery Address: ");
        orderDelTime = new JLabel("Delivery Type: ");
        productText = new JTextField(12);
        emailText = new JTextField(20);
        oTimeText = new JTextField(20);
        pdText = new JTextField(20);
        ptText = new JTextField(20);
        delAddText = new JTextField(20);
        delTimeText = new JTextField(20);

        //will be connected to model and view to get and create data
        if(o.equals("Read")) {
            productText.setText("product1");
            productText.setEditable(false);
            emailText.setText("1234@email.com");
            emailText.setEditable(false);
            oTimeText.setText("12:56");
            oTimeText.setEditable(false);
            pdText.setText("3-25-2022");
            pdText.setEditable(false);
            ptText.setText("Credit");
            ptText.setEditable(false);
            delAddText.setText("1235 St.");
            delAddText.setEditable(false);
            delTimeText.setText("3:58");
            delTimeText.setEditable(false);
            orderButton = new JButton("Update Order");
            orderButton.setPreferredSize((new Dimension(200, 50)));
            orderButton.addActionListener(this);
        } else if (o.equals("Create")) {
            orderButton = new JButton("Create Order");
            orderButton.setPreferredSize((new Dimension(200, 50)));
            orderButton.addActionListener(this);
        }
        else if(o.equals("Update")){
            productText.setText("product1");
            emailText.setText("1234@email.com");
            oTimeText.setText("12:56");
            pdText.setText("3-25-2022");
            ptText.setText("Credit");
            delAddText.setText("1235 St.");
            delTimeText.setText("3:58");
            orderButton = new JButton("Update");
            orderButton.setPreferredSize((new Dimension(200, 50)));
            orderButton.addActionListener(this);
        }
        else{
            System.out.println("Error: Order form view");
            System.exit(0);
        }
        setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        grid.insets = new Insets(1, 0,1,0);
        grid.weightx = 1;
        grid.weighty = 1;

        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.gridx = 0;
        grid.gridy = 0;
        add(orderDetails, grid);

        grid.fill = GridBagConstraints.VERTICAL;
        grid.anchor = GridBagConstraints.EAST;

        grid.gridx = 0;
        grid.gridy = 2;
        add(orderProduct, grid);

        grid.gridx = 0;
        grid.gridy = 3;
        add(orderEmail, grid);

        grid.gridx = 0;
        grid.gridy = 4;
        add(orderT,grid);

        grid.gridx = 0;
        grid.gridy = 5;
        add(orderPaid, grid);

        grid.gridx = 0;
        grid.gridy = 6;
        add(orderPayT,grid);

        grid.gridx = 0;
        grid.gridy = 7;
        add(orderAdd, grid);

        grid.gridx = 0;
        grid.gridy = 8;
        add(orderDelTime, grid);

        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.WEST;
        grid.gridx = 1;
        grid.gridy = 2;
        add(productText, grid);

        grid.gridx = 1;
        grid.gridy = 3;
        add(emailText, grid);

        grid.gridx = 1;
        grid.gridy = 4;
        add(oTimeText, grid);

        grid.gridx = 1;
        grid.gridy = 5;
        add(pdText, grid);

        grid.gridx = 1;
        grid.gridy = 6;
        add(ptText, grid);

        grid.gridx = 1;
        grid.gridy = 7;
        add(delAddText, grid);

        grid.gridx = 1;
        grid.gridy = 8;
        add(delTimeText, grid);

        grid.gridx = 1;
        grid.gridy = 9;
        grid.gridwidth = 1;
        grid.gridheight = 1;
        add(orderButton, grid);
    }
    public void actionPerformed(ActionEvent e){

        //will be connected to model and view to get and create data
        if(e.getSource() == orderButton) {
            if (orderButton.getText().equals("Create Order")) {
                orderController.submitOrder();
            } else if (orderButton.getText().equals("Update Order")) {
                productText.setEditable(true);
                emailText.setEditable(true);
                oTimeText.setEditable(true);
                pdText.setEditable(true);
                ptText.setEditable(true);
                delAddText.setEditable(true);
                delTimeText.setEditable(true);
                orderButton.setText("Update");
            } else if (orderButton.getText().equals("Update")) {

                productText.setText("product1");
                emailText.setText("1234@email.com");
                oTimeText.setText("12:56");
                pdText.setText("3-25-2022");
                ptText.setText("Credit");
                delAddText.setText("1235 St.");
                delTimeText.setText("3:58");
                orderButton.setText("Update Order");
                productText.setEditable(false);
                emailText.setEditable(false);
                oTimeText.setEditable(false);
                pdText.setEditable(false);
                ptText.setEditable(false);
                delAddText.setEditable(false);
                delTimeText.setEditable(false);
            }
        }
    }

    public String getProducts() {
        return products;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public String getPayType() {
        return payType;
    }

    public String getDeliveryAdd() {
        return deliveryAdd;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public JLabel getOrderDetails() {
        return orderDetails;
    }

    public JLabel getOrderProduct() {
        return orderProduct;
    }

    public JLabel getOrderEmail() {
        return orderEmail;
    }

    public JLabel getOrderT() {
        return orderT;
    }

    public JLabel getOrderPaid() {
        return orderPaid;
    }

    public JLabel getOrderPayT() {
        return orderPayT;
    }

    public JLabel getOrderAdd() {
        return orderAdd;
    }

    public JLabel getOrderDelTime() {
        return orderDelTime;
    }

    public JTextField getProductText() {
        return productText;
    }

    public JTextField getEmailText() {
        return emailText;
    }

    public JTextField getoTimeText() {
        return oTimeText;
    }

    public JTextField getPdText() {
        return pdText;
    }

    public JTextField getPtText() {
        return ptText;
    }

    public JTextField getDelAddText() {
        return delAddText;
    }

    public JTextField getDelTimeText() {
        return delTimeText;
    }

}
