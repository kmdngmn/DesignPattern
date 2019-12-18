package lab05_CommandPattern_2;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExecuteUndoCommand extends CommandButton implements Command {

	private ImageIcon imageIcon;
	private JLabel label;
	
	private static ArrayList<ImageIcon> list;

	public ExecuteUndoCommand(ImageIcon imageIcon, JLabel label) {
		this.imageIcon = imageIcon;
		this.label = label;

		list = new ArrayList<ImageIcon>();
	}

	@Override
	public void execute() {

		if(getText().equals("undo")) {
			undo();
			
		}
		else {
			label.setIcon(imageIcon);
			list.add(imageIcon);
		}
		return ;
		
	}

	@Override
	public void undo() {
	
		label.setIcon(list.get(list.size()-2));
		list.add(list.get(list.size()-2));
		
	}

}
