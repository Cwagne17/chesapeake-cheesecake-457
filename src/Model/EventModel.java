package Model;

import Config.errors.StringException;
import Model.dto.CreateEventDto;
import Model.dto.UpdateOrderDto;
import Model.entities.Event;
import Model.interfaces.IEventModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventModel implements IEventModel {
    @Override
    public ArrayList<Event> getEvents() {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT *" +
                        "FROM chesapeake457.Event"
        );
        ResultSet res = stmt.executeQuery();
        return this.buildResponse(res);
    }

    @Override
    public void createEvent(CreateEventDto createEventDto) {

    }

    @Override
    public void updateEvent(UpdateOrderDto updateOrderDto) {

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
