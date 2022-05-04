package Model.interfaces;

import Config.errors.StringException;
import Model.entities.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IClientModel {
    public ArrayList<Client> getClients() throws SQLException, StringException;

    public Client getClient(String email) throws SQLException, StringException;

    public void createClient(
         String email_addr,
         String spouse1_name,
         String spouse2_name,
         String name,
         String phys_addr,
         String phone_num,
         String pref_contact,
         int is_individual
    ) throws SQLException;

    public void updateClient(
         String email,
         String email_addr,
         String spouse1_name,
         String spouse2_name,
         String name,
         String phys_addr,
         String phone_num,
         String pref_contact,
         int is_individual
    ) throws SQLException, StringException;
}
