package Model;

import Config.ConnectionManager;
import Config.errors.StringException;
import Model.entities.Event;
import Model.entities.Ingredient;
import Model.entities.Order;
import Model.interfaces.IOrderModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderModel implements IOrderModel {
    private Connection conn;

    public OrderModel() {
        this.conn = ConnectionManager.getConnection();
    }

    @Override
    public ArrayList<Order> getOrders() {
        return null;
    }

    @Override
    public Event getOrder(String order_client_email, String order_time) throws SQLException, StringException {
        return null;
    }

    @Override
    public void createOrder(String order_client_email, int eventId, String order_time, String paid_date, String payment_type) throws SQLException {

    }

    @Override
    public void updateOrder(int eventId, String paid_date, String payment_type) throws SQLException {

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
