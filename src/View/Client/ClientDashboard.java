package View.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientDashboard extends JPanel {
    private JTextArea textArea1;
    private JButton addClientButton;
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;
    private JList list5;



    public ClientDashboard() {
        add(textArea1);
        add(addClientButton);
        add(list1);
        add(list2);
        add(list3);
        add(list4);
        add(list5);
        addClientButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
            }
        });
    }
}


