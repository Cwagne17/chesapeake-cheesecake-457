package View.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class ClientDashboard {


    public ClientDashboard() {
        initComponents();
        addEventButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             * Open up client form with this action
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //waiting on client form to be made
               System.out.println("This will show the client form to add events");
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        var panel1 = new JPanel();
        var vSpacer1 = new JPanel(null);
        textArea1 = new JTextArea();
        var label1 = new JLabel();
        var label2 = new JLabel();
        var label3 = new JLabel();
        var label4 = new JLabel();
        var label5 = new JLabel();
        addEventButton = new JButton();
        list1 = new JList<>();
        list3 = new JList<>();
        list2 = new JList<>();
        list4 = new JList<>();
        list5 = new JList<>();
        var label6 = new JLabel();

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("1"));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder
            ( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );
            panel1.setLayout(new GridBagLayout());
            panel1.add(vSpacer1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 0), 0, 0));
            panel1.add(textArea1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- label1 ----
            label1.setText("deliveryTime");
            panel1.add(label1, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- label2 ----
            label2.setText(" num_of_guests");
            panel1.add(label2, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- label3 ----
            label3.setText("    allergies");
            panel1.add(label3, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- label4 ----
            label4.setText("delivery address");
            panel1.add(label4, new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- label5 ----
            label5.setText(" email address");
            panel1.add(label5, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- addEventButton ----
            addEventButton.setText("Add Event");
            panel1.add(addEventButton, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- list1 ----
            list1.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "24:00",
                    "24:00",
                    "24:00",
                    "24:00",
                    "24:00",
                    "24:00",
                    "24:00",
                    "24:00",
                    "24:00"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            panel1.add(list1, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- list3 ----
            list3.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "eggs, sugar",
                    "eggs, sugar",
                    "eggs, sugar",
                    "eggs, sugar",
                    "eggs, sugar",
                    "eggs, sugar",
                    "eggs, sugar",
                    "eggs, sugar",
                    "eggs, sugar"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            panel1.add(list3, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- list2 ----
            list2.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "5",
                    "5",
                    "5",
                    "5",
                    "5",
                    "5",
                    "5",
                    "5",
                    "5"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            panel1.add(list2, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- list4 ----
            list4.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "test@gmail.com",
                    "test@gmail.com",
                    "test@gmail.com",
                    "test@gmail.com",
                    "test@gmail.com",
                    "test@gmail.com",
                    "test@gmail.com",
                    "test@gmail.com",
                    "test@gmail.com"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            panel1.add(list4, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- list5 ----
            list5.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "1212 Thing CT, Thing MD 22222",
                    "1212 Thing CT, Thing MD 22222",
                    "1212 Thing CT, Thing MD 22222",
                    "1212 Thing CT, Thing MD 22222",
                    "1212 Thing CT, Thing MD 22222",
                    "1212 Thing CT, Thing MD 22222",
                    "1212 Thing CT, Thing MD 22222",
                    "1212 Thing CT, Thing MD 22222",
                    "1212 Thing CT, Thing MD 22222"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            panel1.add(list5, new GridBagConstraints(6, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- label6 ----
            label6.setText("Events Dashboard");
            panel1.add(label6, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextArea textArea1;
    private JButton addEventButton;
    private JList<String> list1;
    private JList<String> list3;
    private JList<String> list2;
    private JList<String> list4;
    private JList<String> list5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}


