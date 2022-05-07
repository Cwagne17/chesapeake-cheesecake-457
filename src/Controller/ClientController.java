package Controller;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Config.errors.StringException;
import Model.ClientModel;
import Model.entities.Client;
import Utils.Helpers;
import View.Client.ClientForm;
import View.Client.ClientDashboard;
import javax.swing.*;


public class ClientController {

    private ClientModel clientModel = new ClientModel();
    private ClientForm form;
    private ClientDashboard dash;
    private JTable table;

    private List<Client> regClients;

    public ClientController(ClientDashboard dash) {
        this.dash = dash;
    }

    public ClientController(ClientForm form) {
        this.form = form;
    }

    public void submitClient(){
        // submit client
            String name = this.form.getNameText().getText().trim();
            String phys_addr = this.form.getAddressText().getText().trim();
            String email_addr = this.form.getEmailText().getText().trim();
            String phone_num = this.form.getPhoneText().getText().trim();
            String pref_contact = this.form.getContactText().getText().trim();
            int is_individual = 1;

            try {
                this.clientModel.createClient(email_addr, "", "", name, phys_addr, phone_num, pref_contact, is_individual);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }

    public void getClients(){
            try {
                this.regClients = new ArrayList<>(this.clientModel.getClients());
                table = Helpers.getClientTableRows(regClients);
                this.dash.add(table);

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (StringException ex) {
                ex.printStackTrace();
            }
        for(Client client: this.regClients){
            System.out.println(client);
        }

    }

    public void updateClient(){
        // submit client
        String name = this.form.getNameText().getText().trim();
        String phys_addr = this.form.getAddressText().getText().trim();
        String email_addr = this.form.getEmailText().getText().trim();
        String phone_num = this.form.getPhoneText().getText().trim();
        String pref_contact = this.form.getContactText().getText().trim();
        int is_individual = 1;

        try {
            this.clientModel.updateClient(email_addr, email_addr, "","", name, phys_addr, phone_num, pref_contact, is_individual);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (StringException e) {
            e.printStackTrace();
        }
    }



}
