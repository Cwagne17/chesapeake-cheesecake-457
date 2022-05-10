package View.Event;

import Controller.EventController;

import javax.swing.*;

public class EventDashboard extends JPanel {

    private EventController eventController;

    public EventDashboard() {
        this.eventController = new EventController(this);
    }

    public void getEvents() {
        eventController.getEvents();
    }

}
