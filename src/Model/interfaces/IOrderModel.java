package Model.interfaces;

import Config.errors.StringException;
import Model.entities.Event;
import Model.entities.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IOrderModel {

    public ArrayList<Order> getOrders();

    public Event getOrder(String order_client_email, String order_time) throws SQLException, StringException;

    public void createOrder(
         String order_client_email,
         int eventId,
         String order_time,
         String paid_date,
         String payment_type
    ) throws SQLException;

    public void updateOrder(
            int eventId,
            String paid_date,
            String payment_type
    ) throws SQLException;

}
