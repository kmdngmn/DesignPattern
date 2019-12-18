package lab05_CommandPattern_6;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SheepCommandButton extends ExecuteUndoCommandButton implements Command{

	public SheepCommandButton(JLabel label, ImageIcon imageIcon) {
		super(label, imageIcon);
		// TODO Auto-generated constructor stub
	}

}
