package lab04_CommandPattern;

public class LabelWindowCommand extends CommandButton implements Command {
	PrimeObservableThread primeThread;

	public LabelWindowCommand(String txt, PrimeObservableThread primeThread) {

		super(txt);
		this.primeThread = primeThread;

	}

	@Override
	public void execute() {
//		
//		if (updateLabelObserverButton.getText().equals(LABEL_OBSERVER_BUTTON_TITLE)) {
//
//			primeThread.removeObserver(labelWindow);
//			updateLabelObserverButton.setText(ADD_OBSERVER_LABEL_BUTTON);
//		} else if (updateLabelObserverButton.getText().equals(ADD_OBSERVER_LABEL_BUTTON)) {
//			primeThread.addObserver(labelWindow);
//			updateLabelObserverButton.setText(LABEL_OBSERVER_BUTTON_TITLE);
//		}
		//이 부분만 고치면 됨
		
	}
}
