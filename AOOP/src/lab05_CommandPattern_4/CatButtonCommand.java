package lab05_CommandPattern_4;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CatButtonCommand extends ExecuteUndoCommandButton implements Command{

	public CatButtonCommand(JLabel label, ImageIcon imageIcon) {
		super(label, imageIcon);
		// TODO Auto-generated constructor stub
	}

}
