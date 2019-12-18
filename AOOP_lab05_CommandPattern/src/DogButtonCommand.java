import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DogButtonCommand extends ExecuteUndoCommandButton implements Command {

	public DogButtonCommand(ImageIcon imageIcon, JLabel label) {
		super(imageIcon, label);
	}

}
