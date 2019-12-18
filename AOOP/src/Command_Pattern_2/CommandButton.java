package Command_Pattern_2;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CommandButton extends JButton {

	public void setProperties(String text, ActionListener listener, int width, int height) {
		setText(text);
		addActionListener(listener);
		Dimension buttonDimension = new Dimension(width, height);
		setMaximumSize(buttonDimension);
		setMinimumSize(buttonDimension);
		setPreferredSize(buttonDimension);

	}

}
