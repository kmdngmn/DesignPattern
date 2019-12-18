import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExecuteUndoCommandButton extends CommandButton implements Command {

	private ImageIcon imageIcon;
	private JLabel label;

	private static ArrayList<ImageIcon> list;

	public ExecuteUndoCommandButton(ImageIcon imageIcon, JLabel label) {

		this.imageIcon = imageIcon;
		this.label = label;
		list = new ArrayList<ImageIcon>();
	}

	@Override
	public void execute() {

		if (getText().equals("undo")) {
			undo();

		} else {
			label.setIcon(imageIcon);
			list.add(imageIcon);

		}

	}

	@Override
	public void undo() {

		if(list.size() < 2) {
			return;
		}else {		
			label.setIcon(list.get(list.size() - 2)); // 직전에 저장된 이미지를 set함
			list.add(list.get(list.size() - 2)); // undo를 눌렀을 때 set되는 이미지도 list에 넣어야 undo가 제대로 수행됨 
		}
	}
}