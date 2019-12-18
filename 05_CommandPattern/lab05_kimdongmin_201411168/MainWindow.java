import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow extends FrameWindow implements ActionListener {
	private static final int X = 250;
	private static final int Y = 100;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	private static final int NUM_BUTTONS = 5;
	private static final int BUTTON_HEIGHT = 100;

	private CommandButton[] buttons;

	private String[] buttonTitles = { "sheep", "cat", "hedgehog", "dog", "undo" };
	private ImageIcon[] imageIcons;
	private JLabel label;
//	private ImageIcon sheepIcon;
//	private ImageIcon dogIcon;
//	private ImageIcon hedgehogIcon;
//	private ImageIcon catIcon;

	public MainWindow(String title) {
		super();
		imageIcons = new ImageIcon[buttonTitles.length];
		for (int i = 0; i < buttonTitles.length; i++) {

			imageIcons[i] = new ImageIcon(buttonTitles[i] + ".jpg");
			
		}

		createWindow(title, X, Y, WIDTH, HEIGHT);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public JPanel createPanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setPreferredSize(new Dimension(width, BUTTON_HEIGHT));
		buttons = new CommandButton[NUM_BUTTONS];

		label = new JLabel();
		label.setPreferredSize(new Dimension(width, HEIGHT - BUTTON_HEIGHT));

		for (int i = 0; i < NUM_BUTTONS; i++) {

			buttons[i] = new ExecuteUndoCommandButton(imageIcons[i], label);
			buttons[i].createButton(buttonTitles[i], this, width, height);
			buttonPanel.add(buttons[i]);

		}

		panel.add(buttonPanel);

		panel.add(label, BorderLayout.SOUTH);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof Command) {
			Command command = (Command) e.getSource();
			command.execute();
		}
	}
}
