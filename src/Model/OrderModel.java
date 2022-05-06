package Model;

import Config.ConnectionManager;
import Config.errors.StringException;
import Model.entities.Event;
import Model.entities.Ingredient;
import Model.entities.Order;
import Model.interfaces.IOrderModel;
import Model.shared.Validator;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderModel implements IOrderModel {
    private Connection conn;

    public OrderModel() {
        this.conn = ConnectionManager.getConnection();
    }

    @Override
    public ArrayList<Order> getOrders() throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT *" +
                        "FROM chesapeake457.Order"
        );
        ResultSet res = stmt.executeQuery();
        return this.buildResponse(res);
    }

    @Override
    public Order getOrder(String order_client_email, String order_time) throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT * " +
                        "FROM chesapeake457.Order " +
                        "WHERE order_client_email = ? AND order_time = ?");
        stmt.setString(1, order_client_email);
        stmt.setString(2, order_time);
        ResultSet res = stmt.executeQuery();

        ArrayList<Order> events = this.buildResponse(res);
        return events.get(0);
    }

    @Override
    public void createOrder(String order_client_email, int eventId, String order_time, String paid_date, String payment_type) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "INSERT INTO chesapeake457.Order" +
                        "(order_client_email, eventId, order_time, paid_date, payment_type)" +
                        "VALUES (?, ?, ?, ?, ?)"
        );
        stmt.setString(1, order_client_email);
        stmt.setInt(2, eventId);
        stmt.setString(3, order_time);
        stmt.setString(4, paid_date);
        stmt.setString(5, payment_type);

        stmt.executeUpdate();
    }

    @Override
    public void updateOrder(String order_client_email, int eventId, String paid_date, String payment_type) throws SQLException, StringException {
        Order curr_order = this.getOrder(order_client_email, paid_date);
        if (Validator.exists(Integer.toString(eventId))) {
            curr_order.setEventId(eventId);
        }
        if (Validator.exists(payment_type)) {
            curr_order.setPayment_type(payment_type);
        }

        PreparedStatement stmt = this.conn.prepareStatement(
                "UPDATE chesapeake457.Order" +
                        "SET eventId = ?, payment_type = ?" +
                        "WHERE order_client_email = ? AND paid_date = ?"
        );
        stmt.setInt(1, eventId);
        stmt.setString(2, payment_type);
        stmt.setString(3, order_client_email);
        stmt.setString(4, paid_date);

        stmt.executeUpdate();
    }

    private ArrayList<Order> buildResponse(ResultSet res) throws SQLException, StringException {
        ArrayList<Order> ingredients = new ArrayList<>();

        ArrayList<String> attributes = new Order().getAttributeNames();
        while (res.next()) {
            Order obj = new Order();
            for(String attr: attributes) {
                obj.setAttribute(attr, res.getString(attr));
            }
            ingredients.add(obj);
        }
        return ingredients;
    }
}
