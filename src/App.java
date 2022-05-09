
import Config.errors.StringException;
import Model.ClientModel;
import Model.entities.Client;
import View.MainFrame;

import javax.swing.*;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
//        SwingUtilities.invokeLater(MainFrame::new);
        ClientModel cmod = new ClientModel();
        String email = "test@gmail.com";
        try {
            Client client = cmod.getClient(email);
            client.toString();
            cmod.updateClient(email, "", "new ", "new", "new name", "1210 stuff", "111", "phone", 1);
            client = cmod.getClient(email);
            client.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (StringException e) {
            e.printStackTrace();
        }
    }
}