package lab05_CommandPattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DogButtonCommand extends ExecuteUndoCommand implements Command{

	public DogButtonCommand(JLabel label, ImageIcon imageIcon) {
		super(label, imageIcon);
		// TODO Auto-generated constructor stub
	}

}
