package lab05_CommandPattern;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CommandButton extends JButton {

	public void createButton(String title, ActionListener listener, int width, int height) {

		setText(title);
		addActionListener(listener);
		Dimension buttonDimension = new Dimension(width, height);
		setMaximumSize(buttonDimension);
		setMinimumSize(buttonDimension);
		setPreferredSize(buttonDimension);

	}
}
