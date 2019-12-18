package lab05_CommandPattern_4;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SheepButtonCommand extends ExecuteUndoCommandButton implements Command{

	public SheepButtonCommand(JLabel label, ImageIcon imageIcon) {
		super(label, imageIcon);
		// TODO Auto-generated constructor stub
	}

}
