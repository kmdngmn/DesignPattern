package lab07_StatePattern_4;

public class State_0 implements State {

	private MainWindow mainWindow;

	public State_0(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void insert_coin_100() {
		mainWindow.setBalance(mainWindow.getBalance() + 100);
		mainWindow.setState(new State_less_500(mainWindow));
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
	}

	@Override
	public void insert_coin_500() {
		mainWindow.setBalance(mainWindow.getBalance() + 500);
		mainWindow.setState(new State_500(mainWindow));
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
		mainWindow.setBalanceText();
		mainWindow.setMsgText("동전이 없습니다.");
	}

	@Override
	public void select_beverage() {
		mainWindow.setBalanceText();
		mainWindow.setMsgText("동전을 넣은후 레버를 돌려주세요");
	}

}
