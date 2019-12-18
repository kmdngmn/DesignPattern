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
    private JButton[] buttons;
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
        buttons = new JButton[NUM_BUTTONS];
        for (int i = 0; i < NUM_BUTTONS; i++) {
            buttons[i] = createButton(buttonTitles[i], this, width / NUM_BUTTONS, BUTTON_HEIGHT);
            buttonPanel.add(buttons[i]);
        }
        panel.add(buttonPanel);
        label = new JLabel();
        label.setPreferredSize(new Dimension(width, HEIGHT - BUTTON_HEIGHT));
        panel.add(label, BorderLayout.SOUTH);
        return panel;
    }

    private JButton createButton(String text, ActionListener listener, int width, int height) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        Dimension buttonDimension = new Dimension(width, height);
        button.setMaximumSize(buttonDimension);
        button.setMinimumSize(buttonDimension);
        button.setPreferredSize(buttonDimension);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttonTitles.length; i++) {
            if (e.getSource() == buttons[i]) {
                label.setIcon(imageIcons[i]);
            }
        }
    }
}
