import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends FrameWindow implements ActionListener {
    private static final String MAIN_TITLE = "Main Window";
    private static final String TEXTFIELD_WINDOW_TITLE = "TextField Window";
    private static final String LABEL_WINDOW_TITLE = "Label Window";
    private static final String TEXTFIELD_OBSERVER_BUTTON_TITLE = "TextField Window Observer";
    private static final String LABEL_OBSERVER_BUTTON_TITLE = "Label Window Observer";
    private static final String STOP_THREAD_BUTTON_TITLE = "Stop Generating Prime Number";
    private static final int X = 250;
    private static final int Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private static final int GAP = 50;

    private CommandButton stopButton;
    private CommandButton textFieldObserverButton;
    private CommandButton labelObserverButton;
    private PrimeObservableThread primeThread;
    private ObserverWindow textFieldWindow;
    private ObserverWindow labelWindow;
    private boolean labelWindowAdded = true;
    private boolean textFieldWindowAdded = true;
    AbstractObserverWindowFactory factory;

    public MainWindow(String title) {
        super();
        factory = ObserverWindowFactory.getInstance();
        textFieldWindow = factory.create("TextFieldWindow", TEXTFIELD_WINDOW_TITLE, X, Y + HEIGHT + GAP, WIDTH, HEIGHT);
        labelWindow = factory.create("LabelWindow", LABEL_WINDOW_TITLE, X, Y + (HEIGHT + GAP) * 2, WIDTH, HEIGHT);
        primeThread = new PrimeObservableThread();
        createWindow(title, X, Y, WIDTH, HEIGHT);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                primeThread.stopRunning();
                textFieldWindow.closeWindow();
                labelWindow.closeWindow();
                System.exit(0);
            }
        });

        primeThread.addObserver(textFieldWindow);
        primeThread.addObserver(labelWindow);
        primeThread.run();
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(width, height));
        textFieldObserverButton = new TextFieldObserverButtonCommand("Remove ", TEXTFIELD_OBSERVER_BUTTON_TITLE, primeThread, textFieldWindow);
        textFieldObserverButton.setProperties(this, width, height);
        panel.add(textFieldObserverButton);
        labelObserverButton = new LabelObserverButtonCommand("Remove ", LABEL_OBSERVER_BUTTON_TITLE, primeThread, labelWindow);
        labelObserverButton.setProperties(this, width, height);
        panel.add(labelObserverButton);
        stopButton = new StopButtonCommand(STOP_THREAD_BUTTON_TITLE, primeThread);
        stopButton.setProperties(this, width, height);
        panel.add(stopButton);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Command) {
            Command command = (Command) e.getSource();
            command.execute();
        }
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow(MainWindow.MAIN_TITLE);
    }
}
