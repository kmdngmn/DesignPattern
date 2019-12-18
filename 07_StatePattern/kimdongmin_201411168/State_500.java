
public class State_500 implements StateInterface {

	private MainWindow mainWindow;

	public State_500(MainWindow mainWindow) {

		this.mainWindow = mainWindow;
	}

	@Override
	public void insert_coin_100() {
		mainWindow.setBalance(mainWindow.getBalance() + 100);
		if(mainWindow.getBalance() > 500) {
			mainWindow.setState(new State_less_1000(mainWindow));
		}
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
	}

	@Override
	public void insert_coin_500() {
		mainWindow.setBalance(mainWindow.getBalance() + 500);
		if(mainWindow.getBalance() == 1000) {
			mainWindow.setState(new State_equal_more_1000(mainWindow));
		}
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");

	}

	@Override
	public void insert_coin_1000() {
		mainWindow.setBalance(mainWindow.getBalance() + 1000);
		if(mainWindow.getBalance() > 1000) {
			mainWindow.setState(new State_equal_more_1000(mainWindow));
		}
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
	}

	@Override
	public void return_charges() {
		mainWindow.setBalanceText();
		mainWindow.setMsgText("" + mainWindow.getBalance() + "원을 반환합니다");
		mainWindow.setBalance(0);	// 반환 후 0원으로 set
		mainWindow.setBalanceText();
		
		if(mainWindow.getBalance() == 0) {	// 잔액을 반환하면 0원 이므로 State를 State_0으로 돌려야함
			mainWindow.setState(new State_0(mainWindow));
		}
	}

	@Override
	public void select_beverages() {
		mainWindow.setBalanceText();
		mainWindow.setMsgText("1000원 이상을 넣은 후에 눌러주세요");
	}

}
