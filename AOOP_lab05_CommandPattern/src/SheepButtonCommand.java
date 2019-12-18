import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SheepButtonCommand extends ExecuteUndoCommandButton implements Command {

	public SheepButtonCommand(ImageIcon imageIcon, JLabel label) {
		super(imageIcon, label);
	}

}
