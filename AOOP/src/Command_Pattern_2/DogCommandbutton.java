package Command_Pattern_2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DogCommandbutton extends ExecuteUndoCommandButton implements Command{

	public DogCommandbutton(JLabel label, ImageIcon imageIcon) {
		super(label, imageIcon);
		// TODO Auto-generated constructor stub
	}

}
