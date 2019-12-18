package lab04_Factory_SingletonPattern_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends FrameWindow implements ActionListener {
	private static final String MAIN_TITLE = "Main Window";
	private static final String TEXTFIELD_WINDOW_TITLE = "TextField Window";
	private static final String LABEL_WINDOW_TITLE = "Label Window";
	private static final String REMOVE_TEXTFIELD_OBSERVER_BUTTON_TITLE = "Remove TextField Window Observer";
	private static final String REMOVE_LABEL_OBSERVER_BUTTON_TITLE = "Remove Label Window Observer";

	private static final String ADD_TEXTFIELD_OBSERVER_BUTTON_TITLE = "Add TextField Window Observer";
	private static final String ADD_LABEL_OBSERVER_BUTTON_TITLE = "Add Label Window Observer";

	private static final String STOP_THREAD_BUTTON_TITLE = "Stop Generating Prime Number";
	private static final int X = 250;
	private static final int Y = 100;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 200;
	private static final int GAP = 50;

	private JButton stopButton;
	private JButton updateTextFieldObserverButton;
	private JButton updateLabelObserverButton;
	private PrimeObservableThread primeThread;

	private Product textFieldWindow;
	private Product labelWindow;

	public MainWindow(String title) {
		super(title, X, Y, WIDTH, HEIGHT);
//		textFieldWindow = new TextFieldWindow(TEXTFIELD_WINDOW_TITLE, X, Y + HEIGHT + GAP, WIDTH, HEIGHT);
//		labelWindow = new LabelWindow(LABEL_WINDOW_TITLE, X, Y + (HEIGHT + GAP) * 2, WIDTH, HEIGHT);

		textFieldWindow = WindowFactory.getInstance().createWindow("TextField",TEXTFIELD_WINDOW_TITLE, X, Y + HEIGHT + GAP, WIDTH,
				HEIGHT);
		labelWindow = WindowFactory.getInstance().createWindow("Label", LABEL_WINDOW_TITLE, X, Y + (HEIGHT + GAP) * 2, WIDTH,
				HEIGHT);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				primeThread.stopRunning();
				textFieldWindow.closeWindow();
				labelWindow.closeWindow();
				System.exit(0);
			}
		});

		primeThread = new PrimeObservableThread();
		primeThread.addObserver(labelWindow);
		primeThread.addObserver(textFieldWindow);
		primeThread.run();
	}

	public JPanel createPanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setPreferredSize(new Dimension(width, height));
		updateTextFieldObserverButton = createButton(REMOVE_TEXTFIELD_OBSERVER_BUTTON_TITLE, this, width, height);
		panel.add(updateTextFieldObserverButton);
		updateLabelObserverButton = createButton(REMOVE_LABEL_OBSERVER_BUTTON_TITLE, this, width, height);
		panel.add(updateLabelObserverButton);
		stopButton = createButton(STOP_THREAD_BUTTON_TITLE, this, width, height);
		panel.add(stopButton);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateTextFieldObserverButton) {
			if (updateTextFieldObserverButton.getText().equals(REMOVE_TEXTFIELD_OBSERVER_BUTTON_TITLE)) {
				updateTextFieldObserverButton.setText(ADD_TEXTFIELD_OBSERVER_BUTTON_TITLE);
				primeThread.removeObserver(textFieldWindow);
			} else if (updateTextFieldObserverButton.getText().equals(ADD_TEXTFIELD_OBSERVER_BUTTON_TITLE)) {
				updateTextFieldObserverButton.setText(REMOVE_TEXTFIELD_OBSERVER_BUTTON_TITLE);
				primeThread.addObserver(textFieldWindow);
			}
		} else if (e.getSource() == updateLabelObserverButton) {

			if (updateLabelObserverButton.getText().equals(REMOVE_LABEL_OBSERVER_BUTTON_TITLE)) {
				updateLabelObserverButton.setText(ADD_LABEL_OBSERVER_BUTTON_TITLE);
				primeThread.removeObserver(labelWindow);
			} else if (updateLabelObserverButton.getText().equals(ADD_LABEL_OBSERVER_BUTTON_TITLE)) {
				updateLabelObserverButton.setText(REMOVE_LABEL_OBSERVER_BUTTON_TITLE);
				primeThread.addObserver(labelWindow);
			}

		} else if (e.getSource() == stopButton) {
			primeThread.stopRunning();
		}
	}

	private JButton createButton(String text, ActionListener listener, int width, int height) {
		JButton button = new JButton(text);
		button.addActionListener(listener);
		Dimension buttonDimension = new Dimension(width, height / 3);
		button.setMaximumSize(buttonDimension);
		button.setMinimumSize(buttonDimension);
		button.setPreferredSize(buttonDimension);
		return button;
	}

	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow(MainWindow.MAIN_TITLE);
	}
}
