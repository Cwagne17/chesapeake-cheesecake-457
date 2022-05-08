package Utils;

import Model.entities.*;
import Model.entities.Package;

import javax.swing.*;
import java.util.List;

public class Helpers {

    public static JTable getClientTableRows(List<Client> regClients) {
        //headers for the table
        String[] columns = new String[] {
                "Email Address", "Name", "Physical Address", "Phone Number", "Preferred Contact", "Type"
        };

        int i = 0;
        Object[][] data = new Object[regClients.size()][6];
        for (Client client : regClients) {
            String email_addr = client.getEmail_addr();
            String name = client.getName();
            String phys_addr = client.getPhys_addr();
            String phone_num = client.getPhone_num();
            String pref_contact = client.getPref_contact();
            int is_individual = 1;

            for(int j = 0; j < 6; j++) {
                if(j == 0) {
                    data[i][j] = email_addr;
                }
                else if(j == 1){
                    data[i][j] = name;
                }
                else if(j == 2){
                    data[i][j] = phys_addr;
                }
                else if(j == 3){
                    data[i][j] = phone_num;
                }
                else if(j == 4){
                    data[i][j] = pref_contact;
                }
                else if(j == 5){
                    data[i][j] = is_individual;
                }
            }

            i++;
        }

        JTable clientTable = new JTable(data, columns);
        return clientTable;
    }

    public static JTable getOrderTableRows(List<Order> orders) {
        //headers for the table
        String[] columns = new String[] {
                "Order Email", "Order Time", "Paid Date", "Payment Type"
        };

        int i = 0;
        Object[][] data = new Object[orders.size()][4];
        for (Order order : orders) {
            String email_addr = order.getOrder_client_email().trim();
            String order_time = order.getOrder_time().trim();
            String paid_date = order.getPaid_date().trim();
            String payment_type = order.getPayment_type().trim();

            for(int j = 0; j < 4; j++) {
                if(j == 0) {
                    data[i][j] = email_addr;
                }
                else if(j == 1){
                    data[i][j] = order_time;
                }
                else if(j == 2){
                    data[i][j] = paid_date;
                }
                else if(j == 3){
                    data[i][j] = payment_type;
                }

            }

            i++;
        }

        JTable orderTable = new JTable(data, columns);
        return orderTable;
    }

    public static JTable getEventTableRows(List<Event> events) {
        //headers for the table
        String[] columns = new String[] {
            "Delivery Time",
            "Guest Count",
            "Delivery Address",
            "Allergies",
            "Wedding Event",
            "Venue",
            "Budget",
           "Client Email",
           "Package Name"
        };



        int i = 0;
        Object[][] data = new Object[events.size()][9];
        for (Event event : events) {
            String delivery_time = event.getDelivery_time();
            int num_guests = event.getNum_guests();
            String delivery_address = event.getDelivery_address();
            String allergies = event.getAllergies();
            int isWeddingEvent = event.getIsWeddingEvent();
            String venue = event.getVenue();
            int budget = event.getBudget();
            String client_email = event.getClient_email();
            String package_name = event.getPackage_name();

            for(int j = 0; j < 9; j++) {
                if(j == 0) {
                    data[i][j] = delivery_time;
                }
                else if(j == 1){
                    data[i][j] = num_guests;
                }
                else if(j == 2){
                    data[i][j] = delivery_address;
                }
                else if(j == 3){
                    data[i][j] = allergies;
                }
                else if(j == 4){
                    data[i][j] = "Individual";
                } else if(j == 5) {
                    data[i][j] = venue;
                }
                else if(j == 6){
                    data[i][j] = budget;
                } else if(j == 7){
                    data[i][j] = client_email;
                } else if(j == 8){
                    data[i][j] = package_name;
                }
            }


            i++;
        }

        JTable eventTable = new JTable(data, columns);
        return eventTable;
    }


    public static JTable getProductTableRows(List<Product> products) {
    }

    public static JTable getPackageTableRows(List<Package> packages) {
    }

    public static JTable getIngredientTableRows(List<Ingredient> ingredients) {
    }
}
