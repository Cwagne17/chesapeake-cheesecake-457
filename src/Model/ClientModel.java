package Model;

import Config.ConnectionManager;
import Config.errors.StringException;
import Model.dto.CreateClientDto;
import Model.dto.UpdateClientDto;
import Model.entities.Client;
import Model.entities.IndividualClient;
import Model.entities.WeddingClient;
import Model.interfaces.IClientModel;

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
    public Client getClient(String email) throws SQLException, StringException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT * " +
                "FROM chesapeake457.Client " +
                "WHERE email_addr = ?");
        stmt.setString(1, email);
        ResultSet res = stmt.executeQuery();
        Client client = null;
        res.next();
        System.out.println(res.getString("is_individual"));
        if (res.getInt("is_individual") == 1) {
            client = new IndividualClient();
            stmt = this.conn.prepareStatement(
                    "SELECT * " +
                    "FROM chesapeake457.IndividualClient, chesapeake457.Client " +
                    "WHERE email_addr = ? AND individual_email = ?");
        } else {
            client = new WeddingClient();
            stmt = this.conn.prepareStatement(
                    "SELECT * " +
                        "FROM chesapeake457.WeddingClient, chesapeake457.Client " +
                        "WHERE email_addr = ? AND wedding_email = ?");
        }
        stmt.setString(1, email);
        stmt.setString(2, email);
        res = stmt.executeQuery();
        return this.buildResponse(res, client);
    }

    @Override
    public void createClient(CreateClientDto createClientDto) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement(
                "INSERT INTO chesapeake457.Client"
        );
        stmt.executeUpdate();
    }

    @Override
    public void updateClient(UpdateClientDto updateClientDto) {

    }

    private Client buildResponse(ResultSet res, Client obj) throws SQLException, StringException {
        ArrayList<String> attributes = obj.getAttributeNames();
        while (res.next()) {
            for(String attr: attributes) {
                obj.setAttribute(attr, res.getString(attr));
            }
        }
        return obj;
    }
}