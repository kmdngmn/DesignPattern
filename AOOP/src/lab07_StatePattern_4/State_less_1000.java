package lab07_StatePattern_4;

public class State_less_1000 implements State {
	
	private MainWindow mainWindow;

	public State_less_1000(MainWindow mainWindow) {

		this.mainWindow = mainWindow;

	}

	@Override
	public void insert_coin_100() {
		mainWindow.setBalance(mainWindow.getBalance() + 100);
		if(mainWindow.getBalance() == 1000) {			
			mainWindow.setState(new State_equal_more_1000(mainWindow));
		}
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
	}

	@Override
	public void insert_coin_500() {
		mainWindow.setBalance(mainWindow.getBalance() + 500);
		mainWindow.setState(new State_equal_more_1000(mainWindow));
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
	}

	@Override
	public void insert_coin_1000() {
		mainWindow.setBalance(mainWindow.getBalance() + 1000);
		mainWindow.setState(new State_equal_more_1000(mainWindow));
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
	}

	@Override
	public void return_changes() {
		mainWindow.setMsgText(mainWindow.getBalance() + "원을 반환합니다.");
		mainWindow.setBalance(0);
		mainWindow.setState(new State_0(mainWindow));
		mainWindow.setBalanceText();
	}

	@Override
	public void select_beverage() {
		mainWindow.setBalanceText();
		mainWindow.setMsgText("동전이 부족합니다");
	}

}
