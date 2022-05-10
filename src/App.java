
import Config.errors.StringException;
import Model.ClientModel;
import Model.entities.Client;
import View.MainFrame;

import javax.swing.*;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}