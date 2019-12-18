package lab03_DecoratorPattern;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelPanel {
    private JLabel label;

    public void updateText(String msg) {
        label.setText(msg);
        label.validate();
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        
        // 패널을 시각적으로 보기위해 임의 설정
        TitledBorder tb = new TitledBorder(new LineBorder(Color.pink));
		panel.setBorder(tb);
		
        panel.setLayout(new BorderLayout());
        label = new JLabel();
        panel.add(label);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }
}
