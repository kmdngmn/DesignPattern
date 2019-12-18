package lab04_CommandPattern;

public class TextFieldWindowCommand extends CommandButton implements Command{
	PrimeObservableThread primeThread;

	public TextFieldWindowCommand(String txt, PrimeObservableThread primeThread) {

		super(txt);
		this.primeThread = primeThread;

	}

	@Override
	public void execute() {
//		if (updateTextFieldObserverButton.getText().equals(TEXTFIELD_OBSERVER_BUTTON_TITLE)) {
//
//			primeThread.removeObserver(textFieldWindow);
//			updateTextFieldObserverButton.setText(ADD_OBSERVER_TEXTFIELD_BUTTON);
//		} else if (updateTextFieldObserverButton.getText().equals(ADD_OBSERVER_TEXTFIELD_BUTTON)) {
//			primeThread.addObserver(textFieldWindow);
//			updateTextFieldObserverButton.setText(TEXTFIELD_OBSERVER_BUTTON_TITLE);
//		}
		//이 부분만 고치면 됨
	}
}
