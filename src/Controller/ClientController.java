package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Config.errors.StringException;
import Model.ClientModel;
import Model.entities.Client;
import View.Client.ClientForm;
import View.Client.ClientDashboard;


public class ClientController {

    private ClientModel clientModel = new ClientModel();
    private ClientForm form;
    private ClientDashboard dash;

    private List<Client> regClients;

    public ClientController(ClientForm form, ClientDashboard dash) {
        this.form = form;
        this.dash = dash;

        // submit wedding wedding client
        //this.form.submitWeddingClient

        // load users

    }

    public void submitClient(){
        // submit client
            String name = this.form.getNameText().getText().trim();
            String phys_addr = this.form.getAddressText().getText().trim();
            String email_addr = this.form.getEmailText().getText().trim();
            String phone_num = this.form.getPhoneText().getText().trim();
            String pref_contact = this.form.getContactText().getText().trim();
            int is_individual = 1;

            System.out.println(name);
            try {
                this.clientModel.createClient(email_addr, "", "", name, phys_addr, phone_num, pref_contact, is_individual);
                System.out.println(name);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

    }



    public List<Client> getClients(){

            try {
                this.regClients = new ArrayList<>(this.clientModel.getClients());
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (StringException ex) {
                ex.printStackTrace();
            }
        for(Client client: this.regClients){
            System.out.println(client);
        }

        return regClients;
    }

}
