public class ObserverCommandButton extends CommandButton implements Command {
    Subject primeThread;
    boolean added = true;
    ObserverWindow window;
    String text2;

    public ObserverCommandButton(String text, String text2, Subject primeThread, ObserverWindow window) {
        super(text + text2);
        this.primeThread = primeThread;
        this.window = window;
        this.text2 = text2;
    }

    @Override
    public void execute() {
        if (added) {
            primeThread.removeObserver(window);
            added = false;
            setText("Add " + text2);
        }
        else {
            primeThread.addObserver(window);
            added = true;
            setText("Remove " + text2);
        }
    }
}