package Model.entities;

import Config.errors.StringException;

import java.util.ArrayList;
import java.util.Arrays;

public class Order {

    private String order_client_email;
    private int eventId;
    private String order_time;
    private String paid_date;
    private String payment_type;

    public ArrayList<String> getAttributeNames() {
        String[] attributes = {"order_client_email", "eventId", "order_time", "paid_date", "payment_type"};
        return new ArrayList<String>(Arrays.asList(attributes));
    }

    public void setAttribute(String key, String value) throws StringException {
        switch (key) {
            case "order_client_email":
                this.setOrder_client_email(value);
                break;
            case "eventId":
                this.setEventId(Integer.parseInt(value));
                break;
            case "order_time":
                this.setOrder_time(value);
                break;
            case "paid_date":
                this.setPaid_date(value);
                break;
            case "payment_type":
                this.setPayment_type(value);
                break;
            default:
                throw new StringException(String.format("INTERNAL SERVICE ERROR, %s does not exist on type Order.", key));
        }
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setOrder_client_email(String order_client_email) {
        this.order_client_email = order_client_email;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public void setPaid_date(String paid_date) {
        this.paid_date = paid_date;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public int getEventId() {
        return eventId;
    }

    public String getOrder_client_email() {
        return order_client_email;
    }

    public String getOrder_time() {
        return order_time;
    }

    public String getPaid_date() {
        return paid_date;
    }

    public String getPayment_type() {
        return payment_type;
    }
}
