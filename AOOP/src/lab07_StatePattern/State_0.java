package lab07_StatePattern;

public class State_0 implements State {

	private MainWindow mainWindow;

	public State_0(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void insert_100() {
		mainWindow.setState(new State_Less_500(mainWindow));
		mainWindow.setBalance(mainWindow.getBalance() + 100);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
	
	}

	@Override
	public void insert_500() {
		// TODO Auto-generated method stub
		mainWindow.setState(new State_500(mainWindow));
		mainWindow.setBalance(mainWindow.getBalance() + 500);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
		

	}

	@Override
	public void insert_1000() {
		mainWindow.setState(new State_equal_more_1000(mainWindow));
		mainWindow.setBalance(mainWindow.getBalance() + 1000);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("");
		
	}

	@Override
	public void return_charge() {
		// TODO Auto-generated method stub
		mainWindow.setBalanceText();
		mainWindow.setMsgText("반환할 동전이 없습니다.");
	}

	@Override
	public void select_beverage() {
		// TODO Auto-generated method stub
		mainWindow.setBalanceText();
		mainWindow.setMsgText("돈을 넣은 후 눌러주세요.");

	}

}
