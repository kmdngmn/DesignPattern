
public class State_equal_more_1000 implements StateInterface {

	private MainWindow mainWindow;

	public State_equal_more_1000(MainWindow mainWindow) {

		this.mainWindow = mainWindow;
	}

	@Override
	public void insert_coin_100() {
		mainWindow.setBalance(mainWindow.getBalance()+100);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("이미 충분한 돈이 투입되었습니다. 음료를 선택하세요");
	}

	@Override
	public void insert_coin_500() {
		mainWindow.setBalance(mainWindow.getBalance()+500);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("이미 충분한 돈이 투입되었습니다. 음료를 선택하세요");
	}

	@Override
	public void insert_coin_1000() {
		mainWindow.setBalance(mainWindow.getBalance()+1000);
		mainWindow.setBalanceText();
		mainWindow.setMsgText("이미 충분한 돈이 투입되었습니다. 음료를 선택하세요");
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
	public void select_beverages() { // 음료수를 꺼내면서 잔돈을 반환해야함
		mainWindow.setBalanceText();
		mainWindow.setMsgText("음료를 내보냅니다. 배출구를 확인하세요." + " 거스름돈 " + (mainWindow.getBalance() - 1000) + "원을 반환합니다.");	// 음료수 1000원에 팔고 거스름돈 반환
		
		mainWindow.setBalance(mainWindow.getBalance() - 1000);
		mainWindow.setBalanceText();
		
		mainWindow.setBalance(0);
		
		if(mainWindow.getBalance() == 0) {	// 음료수를 배출한 후 잔액을 반환하면 0원 이므로 State를 State_0으로 돌려야함
			mainWindow.setState(new State_0(mainWindow));
		}
	}

}
