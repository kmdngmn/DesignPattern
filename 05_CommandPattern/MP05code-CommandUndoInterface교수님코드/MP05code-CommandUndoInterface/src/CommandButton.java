import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CommandButton extends JButton implements Command {
    JLabel label;
    ImageIcon icon;
    ImageIcon prevIcon;

    CommandButton(String text, JLabel label, ImageIcon icon) {
        super(text);
        this.label = label;
        this.icon = icon;
    }

    public void setProperties(ActionListener listener, int width, int height) {
        addActionListener(listener);
        Dimension buttonDimension = new Dimension(width, height);
        setMaximumSize(buttonDimension);
        setMinimumSize(buttonDimension);
        setPreferredSize(buttonDimension);
    }

    public void setPrevImageIcon(ImageIcon icon) {
        this.prevIcon = icon;
    }

    public ImageIcon getImageIcon() { return icon; }

    @Override
    public void execute() {
        label.setIcon(icon);
    }

    @Override
    public void undo() {
        if (prevIcon != null) {
            label.setIcon(prevIcon);
        }
    }
}
