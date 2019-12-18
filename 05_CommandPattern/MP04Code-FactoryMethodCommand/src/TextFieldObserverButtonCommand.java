import javax.swing.*;

public class TextFieldObserverButtonCommand extends ObserverCommandButton implements Command{
    public TextFieldObserverButtonCommand(String text, String text2, Subject primeThread, ObserverWindow window) {
        super(text, text2, primeThread, window);
    }
}
