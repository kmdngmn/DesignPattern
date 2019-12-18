package lab05_CommandPattern_3;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CatCommandButton extends ExecuteUndoCommand implements Command{

	public CatCommandButton(JLabel label, ImageIcon imageIcon) {
		super(label, imageIcon);
		// TODO Auto-generated constructor stub
	}

}
