import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UndoButtonCommand extends ExecuteUndoCommandButton implements Command{

	public UndoButtonCommand(ImageIcon imageIcon, JLabel label) {
		super(imageIcon, label);
	}

}
