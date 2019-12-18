package lab02_ObserverPattern_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends FrameWindow implements ActionListener {
	private static final String MAIN_TITLE = "Main Window";
	private static final String TEXTFIELD_WINDOW_TITLE = "TextField Window";
	private static final String TEXTFIELD_WINDOW_TITLE2 = "TextField Window2";
	private static final String LABEL_WINDOW_TITLE = "Label Window";
	private static final String TEXTFIELD_OBSERVER_BUTTON_TITLE = "Remove TextField Window Observer";
	private static final String TEXTFIELD_OBSERVER_BUTTON_TITLE2 = "Remove TextField2 Window Observer";
	private static final String LABEL_OBSERVER_BUTTON_TITLE = "Remove Label Window Observer";

	private static final String ADD_OBSERVER_TEXTFIELD = "Add TextField Window Observer";
	private static final String ADD_OBSERVER_TEXTFIELD2 = "Add TextField2 Window Observer";

	private static final String ADD_OBSERVER_LABEL = "Add Label Window Observer";

	private static final String STOP_THREAD_BUTTON_TITLE = "Stop Generating Prime Number";
	private static final int X = 250;
	private static final int Y = 100;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 200;
	private static final int GAP = 50;

	private JButton stopButton;
	private JButton updateTextFieldObserverButton;
	private JButton updateTextField2ObserverButton;

	private JButton updateLabelObserverButton;
	private PrimeObservableThread primeThread;
	private TextFieldWindow textFieldWindow;
	private TextFieldWindow2 textFieldWindow2;

	private LabelWindow labelWindow;

	public MainWindow(String title) {
		super(title, X, Y, WIDTH, HEIGHT);
		textFieldWindow = new TextFieldWindow(TEXTFIELD_WINDOW_TITLE, X, Y + HEIGHT + GAP, WIDTH, HEIGHT);
		textFieldWindow2 = new TextFieldWindow2(TEXTFIELD_WINDOW_TITLE2, X, Y + HEIGHT + GAP, WIDTH, HEIGHT);

		labelWindow = new LabelWindow(LABEL_WINDOW_TITLE, X, Y + (HEIGHT + GAP) * 2, WIDTH, HEIGHT);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				primeThread.stopRunning();
				textFieldWindow.closeWindow();
				textFieldWindow2.closeWindow();

				labelWindow.closeWindow();
				System.exit(0);
			}
		});

		primeThread = new PrimeObservableThread();
		primeThread.addObserver(labelWindow);
		primeThread.addObserver(textFieldWindow);
		primeThread.addObserver(textFieldWindow2);

		primeThread.run();
	}

	public JPanel createPanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setPreferredSize(new Dimension(width, height));
		updateTextFieldObserverButton = createButton(TEXTFIELD_OBSERVER_BUTTON_TITLE, this, width, height);
		panel.add(updateTextFieldObserverButton);

		updateTextField2ObserverButton = createButton(TEXTFIELD_OBSERVER_BUTTON_TITLE2, this, width, height);
		panel.add(updateTextField2ObserverButton);

		updateLabelObserverButton = createButton(LABEL_OBSERVER_BUTTON_TITLE, this, width, height);
		panel.add(updateLabelObserverButton);
		stopButton = createButton(STOP_THREAD_BUTTON_TITLE, this, width, height);
		panel.add(stopButton);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateTextFieldObserverButton) {

			if (updateTextFieldObserverButton.getText().equals(TEXTFIELD_OBSERVER_BUTTON_TITLE)) {

				textFieldWindow.updateText("" + primeThread.getPrimeNumber());
				updateTextFieldObserverButton.setText(ADD_OBSERVER_TEXTFIELD);
				primeThread.removeObserver(textFieldWindow);

			} else if (updateTextFieldObserverButton.getText().equals(ADD_OBSERVER_TEXTFIELD)) {

				primeThread.addObserver(textFieldWindow);
				updateTextFieldObserverButton.setText(TEXTFIELD_OBSERVER_BUTTON_TITLE);
			}

		} else if (e.getSource() == updateLabelObserverButton) {
			if (updateLabelObserverButton.getText().equals(LABEL_OBSERVER_BUTTON_TITLE)) {

				labelWindow.updateText("" + primeThread.getPrimeNumber());
				updateLabelObserverButton.setText(ADD_OBSERVER_LABEL);
				primeThread.removeObserver(labelWindow);

			} else if (updateLabelObserverButton.getText().equals(ADD_OBSERVER_LABEL)) {
				updateLabelObserverButton.setText(LABEL_OBSERVER_BUTTON_TITLE);
				primeThread.addObserver(labelWindow);
			}

		} else if (e.getSource() == updateTextField2ObserverButton) {

			if (updateTextField2ObserverButton.getText().equals(TEXTFIELD_OBSERVER_BUTTON_TITLE2)) {

				textFieldWindow2.updateText("" + primeThread.getPrimeNumber());
				updateTextField2ObserverButton.setText(ADD_OBSERVER_TEXTFIELD2);
				primeThread.removeObserver(textFieldWindow2);

			} else if (updateTextField2ObserverButton.getText().equals(ADD_OBSERVER_TEXTFIELD2)) {

				primeThread.addObserver(textFieldWindow2);
				updateTextField2ObserverButton.setText(TEXTFIELD_OBSERVER_BUTTON_TITLE2);
			}

		}

		else if (e.getSource() == stopButton) {
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
