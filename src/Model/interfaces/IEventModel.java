package Model.interfaces;

import Config.errors.StringException;
import Model.entities.Event;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEventModel {

    public ArrayList<Event> getEvents() throws SQLException, StringException;

    public Event getEvent(String id) throws SQLException, StringException;

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
    ) throws SQLException;

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
    ) throws SQLException, StringException;
    
}
