package lab02_ObserverPattern_5;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelPlusWindow extends FrameWindow implements Observer {

	private JLabel label;

	public LabelPlusWindow(String title, int x, int y, int width, int height) {
		super(title, x, y, width, height);
	}

	@Override
	public void updateText(String msg) {
		label.setText(msg);
		label.validate();
	}

	public JPanel createPanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		label = new JLabel();
		panel.add(label);
		panel.setPreferredSize(new Dimension(width, height));
		return panel;
	}

}
