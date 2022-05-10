package View.Order;

import Controller.OrderController;

import javax.swing.*;

public class OrderDashboard extends JPanel {
    private OrderController orderController;

    public OrderDashboard() {
        this.orderController = new OrderController(this);
    }


    public void getOrders() {
        orderController.getOrders();
    }
}
