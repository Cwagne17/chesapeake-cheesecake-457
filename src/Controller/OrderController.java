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
        String order_time = this.form.getOrderTime().trim();
        String paid_date = this.form.getPaidDate().trim();
        String payment_type = this.form.getPayType().trim();
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

//    public void updateOrder(){
//        // submit client
//        String name = this.form.getNameText().getText().trim();
//        String phys_addr = this.form.getAddressText().getText().trim();
//        String email_addr = this.form.getEmailText().getText().trim();
//        String phone_num = this.form.getPhoneText().getText().trim();
//        String pref_contact = this.form.getContactText().getText().trim();
//        int is_individual = 1;
//
//        try {
//            this.clientModel.updateClient(email_addr, email_addr, "","", name, phys_addr, phone_num, pref_contact, is_individual);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } catch (StringException e) {
//            e.printStackTrace();
//        }
//    }
}
