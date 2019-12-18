package lab05_CommandPattern_2;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CommandButton extends JButton {

	public void createButton(String text, ActionListener listener, int width, int height) {
		setText(text);
		addActionListener(listener);
		Dimension buttonDimension = new Dimension(width, height);
		setMaximumSize(buttonDimension);
		setMinimumSize(buttonDimension);
		setPreferredSize(buttonDimension);

	}
}