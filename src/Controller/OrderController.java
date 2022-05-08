package Controller;

import Config.errors.StringException;
import Model.EventModel;
import Model.entities.Event;
import Model.entities.Order;
import Utils.TableHelpers;
import View.Order.OrderDashboard;
import View.Order.OrderForm;
import Model.OrderModel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private OrderForm form;
    private OrderDashboard dash;
    private OrderModel orderModel = new OrderModel();
    private EventModel eventModel = new EventModel();
    private List<Order> orders = new ArrayList<>();
    private JTable table;

    public OrderController(OrderDashboard dash) {
        this.dash = dash;
    }

    public OrderController(OrderForm form) {
        this.form = form;
    }

    public void submitOrder() throws SQLException, StringException {
        // submit order
        String order_client_email = this.form.getEmailText().getText().trim();
        String order_time = this.form.getoTimeText().getText().trim();
        String paid_date = this.form.getPdText().getText().trim();
        String payment_type = this.form.getPtText().getText().trim();

        Event event = this.eventModel.getEvent(order_client_email);

        try {
            this.orderModel.createOrder(order_client_email, event.getId(), order_time, paid_date, payment_type);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getOrders(){
        try {
            this.orders = new ArrayList<>(this.orderModel.getOrders());
            table = TableHelpers.getOrderTableRows(orders);
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
