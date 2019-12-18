package lab04_Factory_SingletonPattern_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldWindow extends Product{
    private JTextField textField;

    public TextFieldWindow(String type, String title, int x, int y, int width, int height) {
        super(type,title, x, y, width, height);
    }

    @Override
    public void updateText(String msg) {
        textField.setText(msg);
        textField.validate();
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        textField = new JTextField();
        panel.add(textField);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }
}
