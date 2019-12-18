import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CommandButton extends JButton {

	public void createButton(String buttonTitle, ActionListener listener, int width, int height) {
		setText(buttonTitle);
		addActionListener(listener);
		Dimension buttonDimension = new Dimension(width / 5, height);
		setMaximumSize(buttonDimension);
		setMinimumSize(buttonDimension);
		setPreferredSize(buttonDimension);

	}

}