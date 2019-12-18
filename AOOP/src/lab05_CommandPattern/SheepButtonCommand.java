package lab05_CommandPattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SheepButtonCommand extends ExecuteUndoCommand implements Command{

	public SheepButtonCommand(JLabel label, ImageIcon imageIcon) {
		super(label, imageIcon);
		// TODO Auto-generated constructor stub
	}

}
