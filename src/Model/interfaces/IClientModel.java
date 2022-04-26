package Model.interfaces;

import Config.errors.StringException;
import Model.dto.CreateClientDto;
import Model.dto.UpdateClientDto;
import Model.entities.Client;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IClientModel {
    public ArrayList<Client> getClients() throws SQLException, StringException;

    public Client getClient(String email) throws SQLException, StringException;

    public void createClient(CreateClientDto createClientDto) throws SQLException;

    public void updateClient(String email, UpdateClientDto updateClientDto) throws SQLException, StringException;
}
