package lab05_CommandPattern_2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SheepCommandButton extends ExecuteUndoCommand implements Command{

	public SheepCommandButton(ImageIcon imageIcon, JLabel label) {
		super(imageIcon, label);
		// TODO Auto-generated constructor stub
	}

}