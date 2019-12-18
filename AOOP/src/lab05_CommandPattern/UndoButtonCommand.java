package lab05_CommandPattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UndoButtonCommand extends ExecuteUndoCommand implements Command{

	public UndoButtonCommand(JLabel label, ImageIcon imageIcon) {
		super(label, imageIcon);
		// TODO Auto-generated constructor stub
	}

}
