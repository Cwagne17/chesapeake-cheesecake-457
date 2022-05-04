package Model;

import Config.ConnectionManager;
import Config.errors.StringException;
import Model.entities.Event;
import Model.interfaces.IEventModel;

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
    public Event getEvent(String id) throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT * " +
                        "FROM chesapeake457.Event " +
                        "WHERE id = ?");
        stmt.setString(1, id);
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
                    "(delivery_time, num_guests, delivery_address, allergies, isWeddingEvent, venu, budget, client_email, package_name)" +
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
    ) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "UPDATE chesapeake457.Event" +
                        "SET delivery_time = ?, num_guests = ?, delivery_address = ?, allergies = ?, isWeddingEvent = ?, venue = ?, budget = ?, package_name = ?" +
                        "WHERE (id = ?)"
        );
        stmt.setString(1, delivery_time);
        stmt.setInt(2, num_guests);
        stmt.setString(3, delivery_address);
        stmt.setString(4, allergies);
        stmt.setInt(5, isWeddingEvent);
        stmt.setString(6, venue);
        stmt.setInt(7, budget);
        stmt.setString(8, package_name);
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
