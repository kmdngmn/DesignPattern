package lab05_CommandPattern_5;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HedgehogCommandButton extends ExecuteUndoCommandButton implements Command{

	public HedgehogCommandButton(JLabel label, ImageIcon imageIcon) {
		super(label, imageIcon);
		// TODO Auto-generated constructor stub
	}

}
