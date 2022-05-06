package Model;

import Config.ConnectionManager;
import Config.errors.StringException;
import Model.entities.Client;
import Model.interfaces.IClientModel;
import Model.shared.Validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientModel implements IClientModel {
    private Connection conn;

    public ClientModel() {
        this.conn = ConnectionManager.getConnection();
    }


    @Override
    public ArrayList<Client> getClients() throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT *" +
                        "FROM chesapeake457.Client"
        );
        ResultSet res = stmt.executeQuery();
        return this.buildResponse(res);
    }

    @Override
    public Client getClient(String email) throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT * " +
                "FROM chesapeake457.Client " +
                "WHERE email_addr = ?");
        stmt.setString(1, email);
        ResultSet res = stmt.executeQuery();
        ArrayList<Client> clients = this.buildResponse(res);
        return clients.get(0);
    }

    @Override
    public void createClient(String email_addr, String spouse1_name, String spouse2_name, String name, String phys_addr, String phone_num, String pref_contact, int is_individual) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "INSERT INTO chesapeake457.Client" +
                        "(`email_addr`, `phys_addr`, `phone_num`, `pref_contact`, `is_individual`, `name`, `spouse1_name`, `spouse2_name`)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
        );
        stmt.setString(1, email_addr);
        stmt.setString(2, phys_addr);
        stmt.setString(3, phone_num);
        stmt.setString(4, pref_contact);
        stmt.setInt(5, is_individual);
        stmt.setString(6, name);
        stmt.setString(7, spouse1_name);
        stmt.setString(8, spouse2_name);
    }

    @Override
    public void updateClient(String email, String email_addr, String spouse1_name, String spouse2_name, String name, String phys_addr, String phone_num, String pref_contact, int is_individual) throws SQLException, StringException {
        Client currClient = this.getClient(email);

        if (Validator.exists(phys_addr))
            currClient.setAttribute("phys_addr", phys_addr);
        if (Validator.exists(phone_num))
            currClient.setAttribute("phone_num", phone_num);
        if (Validator.exists(pref_contact))
            currClient.setAttribute("pref_contact", pref_contact);
        if (Validator.exists(name))
            currClient.setAttribute("name", name);
        if (Validator.exists(spouse1_name))
            currClient.setAttribute("spouse1_name", spouse1_name);
        if (Validator.exists(spouse2_name))
            currClient.setAttribute("spouse2_name", spouse2_name);
        currClient.setAttribute("is_individual", Integer.toString(is_individual));

        PreparedStatement stmt = this.conn.prepareStatement(
                "UPDATE  chesapeake457.Client" +
                        "SET `phys_addr` = ?, `phone_num` = ?, `pref_contact` = ?, `is_individual` = ?, `name` = ?, `spouse1_name` = ?, `spouse2_name` = ?" +
                        "WHERE (`email_addr` = ?)"
        );
        stmt.setString(1, currClient.getPhys_addr());
        stmt.setString(2, currClient.getPhone_num());
        stmt.setString(3, currClient.getPref_contact());
        stmt.setInt(4, currClient.getIs_individual());
        stmt.setString(5, currClient.getName());
        stmt.setString(6, currClient.getSpouse1_name());
        stmt.setString(7, currClient.getSpouse2_name());
        stmt.setString(8, email);

        stmt.executeUpdate();
    }

    private ArrayList<Client> buildResponse(ResultSet res) throws SQLException, StringException {
        ArrayList<Client> clients = new ArrayList<>();

        ArrayList<String> attributes = new Client().getAttributeNames();
        while (res.next()) {
            Client obj = new Client();
            for(String attr: attributes) {
                obj.setAttribute(attr, res.getString(attr));
            }
            clients.add(obj);
        }
        return clients;
    }
}