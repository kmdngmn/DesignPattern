import javax.swing.*;

public class StopButtonCommand extends CommandButton implements Command {
    PrimeObservableThread primeThread;

    public StopButtonCommand(String text, PrimeObservableThread primeThread) {
        super(text);
        this.primeThread = primeThread;
    }

    @Override
    public void execute() {
        primeThread.stopRunning();
    }
}
