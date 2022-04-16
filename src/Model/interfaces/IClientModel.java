package Model.interfaces;

import Config.errors.StringException;
import Model.dto.CreateClientDto;
import Model.dto.UpdateClientDto;
import Model.entities.Client;

import java.sql.SQLException;

public interface IClientModel {
    public Client getClient(String email) throws SQLException, StringException;

    public void createClient(CreateClientDto createClientDto) throws SQLException;

    public void updateClient(UpdateClientDto updateClientDto) throws SQLException;
}
