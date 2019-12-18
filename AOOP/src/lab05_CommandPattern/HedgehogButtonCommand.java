package lab05_CommandPattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HedgehogButtonCommand extends ExecuteUndoCommand implements Command {

	public HedgehogButtonCommand(JLabel label, ImageIcon imageIcon) {
		super(label, imageIcon);
		// TODO Auto-generated constructor stub
	}

}
