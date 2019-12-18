import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends FrameWindow implements ActionListener {
    private static final int X = 250;
    private static final int Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int NUM_BUTTONS = 5;
    private static final int BUTTON_HEIGHT = 100;
    private static final String UNDO_BUTTON_TITLE = "undo";
    private CommandButton[] buttons;
    private UndoCommandButton undoCommandButton;
    private Command prevCommand = null;

    private String[] buttonTitles = { "sheep", "cat", "hedgehog", "dog" };
    private ImageIcon[] imageIcons;
    private JLabel label;
    private ImageIcon sheepIcon;
    private ImageIcon dogIcon;
    private ImageIcon hedgehogIcon;
    private ImageIcon catIcon;

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

        label = new JLabel();

        buttons = new CommandButton[NUM_BUTTONS];
        for (int i = 0; i < NUM_BUTTONS - 1; i++) {
            buttons[i] = new CommandButton(buttonTitles[i], label, imageIcons[i]);
            buttons[i].setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
            buttonPanel.add(buttons[i]);
        }
        // creates undo button
        undoCommandButton = new UndoCommandButton(UNDO_BUTTON_TITLE, label);
        undoCommandButton.setProperties(this, width / NUM_BUTTONS, BUTTON_HEIGHT);
        buttonPanel.add(undoCommandButton);

        panel.add(buttonPanel);
        label.setPreferredSize(new Dimension(width, HEIGHT - BUTTON_HEIGHT));
        panel.add(label, BorderLayout.SOUTH);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof CommandButton) {
            Command command = (Command) e.getSource();
            command.execute();
            if (!(command instanceof UndoCommandButton)) {
                undoCommandButton.setLastCommand(command);
                if (prevCommand != null)
                    ((CommandButton) command).setPrevImageIcon(((CommandButton) prevCommand).getImageIcon());
                prevCommand = command;
            }
        }
    }
}
