package Utils;

import Model.entities.Client;
import View.Client.ClientDashboard;
import View.MainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
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

            System.out.println("GET CLIENT TABLE ROWS");
            i++;
        }

        JTable clientTable = new JTable(data, columns);
        return clientTable;
    }


}
