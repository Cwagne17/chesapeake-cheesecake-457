package Model.interfaces;

import Model.dto.CreateEventDto;
import Model.dto.UpdateOrderDto;
import Model.entities.Event;

import java.util.ArrayList;

public interface IEventModel {

    public ArrayList<Event> getEvents();

    public void createEvent(CreateEventDto createEventDto);

    public void updateEvent(UpdateOrderDto updateOrderDto);
    
}
