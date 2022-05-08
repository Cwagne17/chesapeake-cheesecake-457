package Controller;

import Config.errors.StringException;
import Model.EventModel;
import Model.OrderModel;
import Model.entities.Event;
import Model.entities.Order;
import Utils.Helpers;
import View.Event.EventDashboard;
import View.Event.EventForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventController {
    private EventForm form;
    private EventDashboard dash;
    private EventModel eventModel = new EventModel();
    private List<Event> events = new ArrayList<>();
    private JTable table;

    // Other attrs
    private String delivery_time;
    private int num_guests;
    private String delivery_address;
    private String allergies;

    private int isWeddingEvent;
    private String venue;
    private int budget;

    // FK
    private String client_email;
    private String package_name;

    public EventController(EventDashboard dash) {
        this.dash = dash;
    }

    public EventController(EventForm form) {
        this.form = form;
    }

    public void submitEvent() throws SQLException, StringException {
        // submit event

        String delivery_time = this.form.getDeliveryTimeText().getText().trim();
        Integer num_guests = Integer.valueOf(this.form.getNumGuestsText().getText().trim());
        String delivery_address = this.form.getDeliveryAddressText().getText().trim();
        String allergies = this.form.getAllergiesText().getText().trim();
        int isWeddingEvent = 0;
        String venue = this.form.getVenueText().getText().trim();
        int budget = Integer.valueOf(this.form.getBudgetText().getText().trim());
        String client_email = this.form.getClientEmailText().getText().trim();
        String package_name = this.form.getPackageNameText().getText().trim();

        try {
            this.eventModel.createEvent(delivery_time, num_guests, delivery_address, allergies, isWeddingEvent,
                    venue, budget, client_email, package_name);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getEvents(){
        try {
            this.events= new ArrayList<Event>(this.eventModel.getEvents());
            table = Helpers.getEventTableRows(events);
            this.dash.add(table);
        } catch (SQLException | StringException ex) {
            ex.printStackTrace();
        }
        for(Event event: this.events){
            System.out.println(event);
        }
    }

}
