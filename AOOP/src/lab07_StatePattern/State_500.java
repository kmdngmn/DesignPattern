package lab07_StatePattern;

public class State_500 implements State{
	
	private MainWindow mainWindow;

	public State_500(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
	@Override
	public void insert_100() {
		mainWindow.setBalance(mainWindow.getBalance() + 100);
		if(mainWindow.getBalance() > 500) {
			mainWindow.setState(new State_Less_1000(mainWindow));
		}
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
		
	}

	@Override
	public void insert_500() {
		mainWindow.setBalance(mainWindow.getBalance() + 500);
		if(mainWindow.getBalance() == 1000) {
			mainWindow.setState(new State_equal_more_1000(mainWindow));
		}
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
		
	}

	@Override
	public void insert_1000() {
		mainWindow.setBalance(mainWindow.getBalance() + 1000);
		if(mainWindow.getBalance() > 1000) {
			mainWindow.setState(new State_equal_more_1000(mainWindow));
		}
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
		
	}

	@Override
	public void return_charge() {
		// TODO Auto-generated method stub
		mainWindow.setMsgText(mainWindow.getBalance() + "원을  반환합니다.");
		mainWindow.setBalance(0);
		mainWindow.setState(new State_0(mainWindow));
		mainWindow.setBalanceText();
	}

	@Override
	public void select_beverage() {
		// TODO Auto-generated method stub
		mainWindow.setBalanceText();
		mainWindow.setMsgText("돈이 모자랍니다.");

	}

}
