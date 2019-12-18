package lab07_StatePattern;

public class State_equal_more_1000 implements State {

	private MainWindow mainWindow;

	public State_equal_more_1000(MainWindow mainWindow) {

		this.mainWindow = mainWindow;
	}

	@Override
	public void insert_100() {
		mainWindow.setBalance(mainWindow.getBalance() + 100);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("이미 충분한 돈이 투입되었습니다.");
	}

	@Override
	public void insert_500() {
		mainWindow.setBalance(mainWindow.getBalance() + 500);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("이미 충분한 돈이 투입되었습니다.");
	}

	@Override
	public void insert_1000() {
		mainWindow.setBalance(mainWindow.getBalance() + 1000);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("이미 충분한 돈이 투입되었습니다.");
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

		mainWindow.setMsgText("음료수를 배출합니다" + (mainWindow.getBalance() - 1000) + " 원을 반환합니다");
		mainWindow.setBalance(mainWindow.getBalance() - 1000);
		mainWindow.setBalanceText();
		mainWindow.setBalance(0);
		mainWindow.setState(new State_0(mainWindow));

	}

}
