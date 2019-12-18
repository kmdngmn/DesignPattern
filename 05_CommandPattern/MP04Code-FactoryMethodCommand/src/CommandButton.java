import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CommandButton extends JButton {
    public CommandButton(String text) {
        super(text);
    }

    public void setProperties(ActionListener listener, int width, int height) {
        addActionListener(listener);
        Dimension buttonDimension = new Dimension(width, height / 3);
        setMaximumSize(buttonDimension);
        setMinimumSize(buttonDimension);
        setPreferredSize(buttonDimension);
    }

//    @Override
//    public abstract void execute();
}
