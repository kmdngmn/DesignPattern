package lab07_StatePattern_5;

public class State_0 implements StateInterface{
	
	private MainWindow mainWindow;
	
	public State_0(MainWindow mainWindow) {
		
		this.mainWindow = mainWindow;
	}

	@Override
	public void insert_coin_100() {
		mainWindow.setBalance(mainWindow.getBalance() + 100);
		if(mainWindow.getBalance() > 0 && mainWindow.getBalance() < 500) {
			mainWindow.setState(new State_less_500(mainWindow));
		}
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
	}

	@Override
	public void insert_coin_500() {
		mainWindow.setBalance(mainWindow.getBalance() + 500);
		if(mainWindow.getBalance() == 500) {
			mainWindow.setState(new State_500(mainWindow));
		}
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
		
	}

	@Override
	public void insert_coin_1000() {
		mainWindow.setBalance(mainWindow.getBalance() + 1000);
		if(mainWindow.getBalance() == 1000) {
			mainWindow.setState(new State_equal_more_1000(mainWindow));
		}
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
	}

	@Override
	public void return_charges() {
		mainWindow.setBalanceText();
		mainWindow.setMsgText("반환 할 잔액이 없습니다.");
	}

	@Override
	public void select_beverages() {
		mainWindow.setBalanceText();
		mainWindow.setMsgText("돈을 넣은 후에 눌러주세요");
	}

}
