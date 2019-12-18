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
    private static final int NUM_BUTTONS = 4;
    private static final int BUTTON_HEIGHT = 100;
    private static final String UNDO_BUTTON_TITLE = "undo";
    private CommandButton[] buttons;
    private CommandButton undoCommandButton;
    private Command privCommand;
    private String[] buttonTitles = { "sheep", "cat", "hedgehog", "dog" };
    private ImageIcon[] imageIcons;
    private JLabel label;

    public MainWindow(String title) {
        super();
//        imageIcons = new ImageIcon[buttonTitles.length];
//        for (int i = 0; i < buttonTitles.length; i++) {
//            imageIcons[i] = new ImageIcon(buttonTitles[i] + ".jpg");
//        }
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
        label = new JLabel();

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setPreferredSize(new Dimension(width, BUTTON_HEIGHT));
        buttons = new CommandButton[NUM_BUTTONS];
        for (int i = 0; i < NUM_BUTTONS; i++) {
            buttons[i] = new CommandButton(buttonTitles[i], label, imageIcons[i]);
            buttons[i].setProperties(this, width / (NUM_BUTTONS + 1), BUTTON_HEIGHT);
            buttonPanel.add(buttons[i]);
        }
        undoCommandButton = new UndoCommandButton(UNDO_BUTTON_TITLE, label);
        undoCommandButton.setProperties(this, width / (NUM_BUTTONS + 1), BUTTON_HEIGHT);
        buttonPanel.add(undoCommandButton);
        panel.add(buttonPanel);

        label.setPreferredSize(new Dimension(width, HEIGHT - BUTTON_HEIGHT));
        panel.add(label, BorderLayout.SOUTH);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Command) {
            Command command = (Command) e.getSource();
            command.execute();
//            for (int i = 0; i < buttonTitles.length; i++) {
//                if (privCommand == buttons[i]) {
//                    undoCommandButton.setImageIcon(imageIcons[i]);
//                    break;
//                }
//            }
            if (privCommand != null) {
                undoCommandButton.setImageIcon(((CommandButton)privCommand).getImageIcon());
            }
            privCommand = command;
        }
    }
}
