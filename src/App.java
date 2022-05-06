import Model.entities.Client;

import Model.ClientModel;

public class App {
    public static void main(String[] args) {
//        SwingUtilities.invokeLater(MainFrame::new);
        ClientModel client = new ClientModel();
        try {
            Client res = client.getClient("test@gmail.com");
            System.out.println(res.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}