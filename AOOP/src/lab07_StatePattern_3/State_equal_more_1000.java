package lab07_StatePattern_3;

public class State_equal_more_1000 implements State {

	private MainWindow mainWindow;

	public State_equal_more_1000(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void insert_coin_100() {

		mainWindow.setBalance(mainWindow.getBalance() + 100);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("동전이 충분합니다.");

	}

	@Override
	public void insert_coin_500() {
		mainWindow.setBalance(mainWindow.getBalance() + 500);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("동전이 충분합니다.");

	}

	@Override
	public void insert_coin_1000() {
		mainWindow.setBalance(mainWindow.getBalance() + 1000);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("동전이 충분합니다.");
	}

	@Override
	public void return_changes() {

		mainWindow.setMsgText(mainWindow.getBalance() + "원을 반환합니다.");
		mainWindow.setBalance(0);
		mainWindow.setBalanceText();
		mainWindow.setState(new State_0(mainWindow));

	}

	@Override
	public void select_beverage() {

		mainWindow.setBalance(mainWindow.getBalance() - 1000);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("음료를 배출합니다, 잔돈 " + mainWindow.getBalance() + "원을 반환합니다.");
		mainWindow.setBalance(0);
		mainWindow.setState(new State_0(mainWindow));
	}

}
