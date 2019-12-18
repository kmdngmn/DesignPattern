package lab05_CommandPattern_5;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExecuteUndoCommandButton extends CommandButton implements Command {

	private JLabel label;
	private ImageIcon imageIcon;

	private static List<ImageIcon> list;

	public ExecuteUndoCommandButton(JLabel label, ImageIcon imageIcon) {

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

		if(list.size() >= 2) {
			label.setIcon(list.get(list.size()-2));
			list.add(list.get(list.size()-2));
		}
		
	}

}
