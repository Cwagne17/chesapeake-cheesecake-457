package Controller;

import Config.errors.StringException;
import Model.entities.Client;
import Model.entities.Order;
import Utils.Helpers;
import View.Order.OrderDashboard;
import View.Order.OrderForm;
import Model.OrderModel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderController {
    private OrderForm form;
    private OrderDashboard dash;
    private OrderModel orderModel = new OrderModel();
    private List<Order> orders = new ArrayList<>();
    private JTable table;

    public OrderController(OrderDashboard dash) {
        this.dash = dash;
    }

    public OrderController(OrderForm form) {
        this.form = form;
    }

    public void submitOrder(){
        // submit order
        String order_client_email = this.form.getEmailText().getText().trim();
        String order_time = this.form.getoTimeText().getText().trim();
        String paid_date = this.form.getPdText().getText().trim();
        String payment_type = this.form.getPtText().getText().trim();
        int eventId  = (int)UUID.randomUUID().getLeastSignificantBits();

        try {
            this.orderModel.createOrder(order_client_email, eventId, order_time, paid_date, payment_type);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getOrders(){
        try {
            this.orders = new ArrayList<>(this.orderModel.getOrders());
            table = Helpers.getOrderTableRows(orders);
            this.dash.add(table);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (StringException ex) {
            ex.printStackTrace();
        }
        for(Order order: this.orders){
            System.out.println(order);
        }

    }

}
