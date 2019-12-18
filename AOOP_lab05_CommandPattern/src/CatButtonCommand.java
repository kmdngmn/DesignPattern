import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CatButtonCommand extends ExecuteUndoCommandButton implements Command {

	public CatButtonCommand(ImageIcon imageIcon, JLabel label) {
		super(imageIcon, label);
	}

}
