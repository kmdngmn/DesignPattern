package lab02_ObserverPattern_2;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldWindow2 extends FrameWindow implements Observer {
	private JTextField textField;

	public TextFieldWindow2(String title, int x, int y, int width, int height) {
		super(title, x, y, width, height);
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
