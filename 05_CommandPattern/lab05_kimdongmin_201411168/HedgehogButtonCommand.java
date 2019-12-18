import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HedgehogButtonCommand extends ExecuteUndoCommandButton implements Command{

	public HedgehogButtonCommand(ImageIcon imageIcon, JLabel label) {
		super(imageIcon, label);
	}

}
