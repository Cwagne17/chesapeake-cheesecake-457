package Model;

import Config.ConnectionManager;
import Config.errors.StringException;
import Model.entities.Event;
import Model.interfaces.IEventModel;
import Model.shared.Validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventModel implements IEventModel {
    private Connection conn;

    public EventModel() {
        this.conn = ConnectionManager.getConnection();
    }

    @Override
    public ArrayList<Event> getEvents() throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT *" +
                    "FROM chesapeake457.Event"
        );
        ResultSet res = stmt.executeQuery();
        return this.buildResponse(res);
    }

    @Override
    public Event getEvent(String client_email) throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT * " +
                        "FROM chesapeake457.Event " +
                        "WHERE client_email = ?");
        stmt.setString(1, client_email);
        ResultSet res = stmt.executeQuery();
        ArrayList<Event> events = this.buildResponse(res);
        return events.get(0);
    }

    @Override
    public void createEvent(
            String delivery_time,
            int num_guests,
            String delivery_address,
            String allergies,
            int isWeddingEvent,
            String venue,
            int budget,
            String client_email,
            String package_name
    ) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "INSERT INTO chesapeake457.Event" +
                    "(delivery_time, num_guests, delivery_address, allergies, isWeddingEvent, venue, budget, client_email, package_name)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );
        stmt.setString(1, delivery_time);
        stmt.setInt(2, num_guests);
        stmt.setString(3, delivery_address);
        stmt.setString(4, allergies);
        stmt.setInt(5, isWeddingEvent);
        stmt.setString(6, venue);
        stmt.setInt(7, budget);
        stmt.setString(8, client_email);
        stmt.setString(9, package_name);

        stmt.executeUpdate();
    }

    @Override
    public void updateEvent(
            String id,
            String delivery_time,
            int num_guests,
            String delivery_address,
            String allergies,
            int isWeddingEvent,
            String venue,
            int budget,
            String package_name
    ) throws SQLException, StringException {
        Event curr_event = this.getEvent(id);
        if (Validator.exists(delivery_address)) {
            curr_event.setDelivery_address(delivery_address);
        }
        if (Validator.exists(String.valueOf(num_guests))) {
            curr_event.setNum_guests(num_guests);
        }
        if (Validator.exists(delivery_time)) {
            curr_event.setDelivery_time(delivery_time);
        }
        if (Validator.exists(allergies)) {
            curr_event.setAllergies(allergies);
        }
        if (Validator.exists(String.valueOf(isWeddingEvent))) {
            curr_event.setIsWeddingEvent(isWeddingEvent == 1);
        }
        if (Validator.exists(venue)) {
            curr_event.setVenue(venue);
        }
        if (Validator.exists(String.valueOf(budget))) {
            curr_event.setBudget(budget);
        }
        if (Validator.exists(package_name)) {
            curr_event.setPackage_name(package_name);
        }

        PreparedStatement stmt = this.conn.prepareStatement(
                "UPDATE chesapeake457.Event" +
                        "SET delivery_time = ?, num_guests = ?, delivery_address = ?, allergies = ?, isWeddingEvent = ?, venue = ?, budget = ?, package_name = ?" +
                        "WHERE (id = ?)"
        );

        stmt.setString(1, curr_event.getDelivery_time());
        stmt.setInt(2, curr_event.getNum_guests());
        stmt.setString(3, curr_event.getDelivery_address());
        stmt.setString(4, curr_event.getAllergies());
        stmt.setInt(5, curr_event.getIsWeddingEvent());
        stmt.setString(6, curr_event.getVenue());
        stmt.setInt(7, curr_event.getBudget());
        stmt.setString(8, curr_event.getPackage_name());

        stmt.executeUpdate();
    }

    private ArrayList<Event> buildResponse(ResultSet res) throws SQLException, StringException {
        ArrayList<Event> events = new ArrayList<>();

        ArrayList<String> attributes = new Event().getAttributeNames();
        while (res.next()) {
            Event obj = new Event();
            for(String attr: attributes) {
                obj.setAttribute(attr, res.getString(attr));
            }
            events.add(obj);
        }
        return events;
    }
}
