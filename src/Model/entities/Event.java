package Model.entities;

import Config.errors.StringException;

import java.util.ArrayList;
import java.util.Arrays;

public class Event {
    // PK
    private int id;

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

    public Event() {}

    //Getters
    public ArrayList<String> getAttributeNames() {
        String[] attributes = {"id", "delivery_time", "num_guests", "delivery_address", "allergies", "isWeddingEvent", "venue", "budget", "client_email", "package_name"};
        return new ArrayList<String>(Arrays.asList(attributes));
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public int getBudget() {
        return budget;
    }

    public int getIsWeddingEvent() {
        return isWeddingEvent;
    }

    public int getNum_guests() {
        return num_guests;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getClient_email() {
        return client_email;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public int getId() {
        return id;
    }

    public String getPackage_name() {
        return package_name;
    }

    public String getVenue() {
        return venue;
    }

    // Setters
    public void setAttribute(String key, String value) throws StringException {
        switch (key) {
            case "id":
                this.setId(value);
                break;
            case "delivery_time":
                this.setDelivery_time(value);
                break;
            case "num_guests":
                this.setNum_guests(Integer.parseInt(value));
                break;
            case "delivery_address":
                this.setDelivery_address(value);
                break;
            case "allergies":
                this.setAllergies(value);
                break;
            case "isWeddingEvent":
                this.setIsWeddingEvent(value.equals("1"));
                break;
            case "venue":
                this.setVenue(value);
                break;
            case "budget":
                this.setBudget(Integer.parseInt(value));
                break;
            case "client_email":
                this.setClient_email(value);
                break;
            case "package_name":
                this.setPackage_name(value);
                break;
            default:
                throw new StringException(String.format("INTERNAL SERVICE ERROR, %s does not exist on type Client.", key));
        }
    }

    private void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public void setIsWeddingEvent(boolean isWeddingEvent) {
        this.isWeddingEvent = isWeddingEvent ? 1 : 0;
    }

    public void setNum_guests(int num_guests) {
        this.num_guests = num_guests;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", delivery_time=" + delivery_time +
                ", num_guests=" + num_guests +
                ", delivery_address='" + delivery_address + '\'' +
                ", allergies='" + allergies + '\'' +
                ", isWeddingEvent=" + isWeddingEvent +
                ", venue='" + venue + '\'' +
                ", budget=" + budget +
                ", client_email='" + client_email + '\'' +
                ", package_name='" + package_name + '\'' +
                '}';
    }
}
