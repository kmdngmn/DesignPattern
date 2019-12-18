import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class CommandButton extends JButton implements Command {
    JLabel label;
    ImageIcon imageIcon;

    public CommandButton(String text, JLabel label, ImageIcon icon) {
        super(text);
        this.label = label;
        this.imageIcon = icon;
    }

    public void execute() {
        label.setIcon(imageIcon);
    }

    public void setProperties(ActionListener listener, int width, int height) {
        addActionListener(listener);
        Dimension buttonDimension = new Dimension(width, height);
        setMaximumSize(buttonDimension);
        setMinimumSize(buttonDimension);
        setPreferredSize(buttonDimension);
    }

    ImageIcon getImageIcon() {
        return imageIcon;
    }

    void setImageIcon(ImageIcon icon) {
        imageIcon = icon;
    }
}
