package lab04_CommandPattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelWindow extends Product {
	private JLabel label;

	public LabelWindow(String title, int x, int y, int width, int height) {
//		super(title, x, y, width, height);
		createWindow(title, x, y, width, height);
		
	}

	@Override
	public void updateText(String msg) {
		label.setText(msg);
		label.validate();
	}

	@Override
	public JPanel createPanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		label = new JLabel();
		panel.add(label);
		panel.setPreferredSize(new Dimension(width, height));
		return panel;

	}

}