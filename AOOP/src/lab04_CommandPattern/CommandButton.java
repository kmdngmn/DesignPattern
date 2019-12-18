package lab04_CommandPattern;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CommandButton extends JButton {

	public CommandButton(String txt) {
		super(txt);
	}

	public void createButton(ActionListener listener, int width, int height) {

		addActionListener(listener);
		Dimension buttonDimension = new Dimension(width, height / 3);
		setMaximumSize(buttonDimension);
		setMinimumSize(buttonDimension);
		setPreferredSize(buttonDimension);
	}

}
