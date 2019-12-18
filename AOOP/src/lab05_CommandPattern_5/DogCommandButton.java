package lab05_CommandPattern_5;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DogCommandButton extends ExecuteUndoCommandButton implements Command {

	public DogCommandButton(JLabel label, ImageIcon imageIcon) {
		super(label, imageIcon);
		// TODO Auto-generated constructor stub
	}

}
