package lab04_CommandPattern;

public class StopButtonCommand extends CommandButton implements Command {

	PrimeObservableThread primeThread;

	public StopButtonCommand(String txt, PrimeObservableThread primeThread) {

		super(txt);
		this.primeThread = primeThread;

	}

	@Override
	public void execute() {
		primeThread.stopRunning();

	}

}
