package lab05_CommandPattern_3;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExecuteUndoCommand extends CommandButton implements Command {

	private JLabel label;
	private ImageIcon imageIcon;

	private static ArrayList<ImageIcon> list;

	public ExecuteUndoCommand(JLabel label, ImageIcon imageIcon) {

		this.label = label;
		this.imageIcon = imageIcon;

		list = new ArrayList<ImageIcon>();

	}

	@Override
	public void execute() {
		if (getText().equals("undo")) {
			undo();
			return;
		}

		label.setIcon(imageIcon);
		list.add(imageIcon);

	}

	@Override
	public void undo() {

		if (list.size() >= 2) {
			label.setIcon(list.get(list.size() - 2));
			list.add(list.get(list.size() - 2));
		}

	}

}
