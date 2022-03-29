package View;

import javax.swing.*;

public class TestForm extends JPanel {
    public TestForm() {
        mainLabel = new JLabel("Label");
        add(mainLabel);
    }

    private JLabel mainLabel;
}
