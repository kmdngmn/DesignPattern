package lab03_DecoratorPattern_6;

import javax.swing.*;
import java.awt.event.WindowListener;

public abstract class FrameWindow {

    public abstract JPanel createPanel(int width, int height);
}
