package State_Pattern;

public class SoldState implements State {
	GumballMachine gumballMachine;

	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;

	}

	@Override
	public void insertQuarter() {
		System.out.println("물건을 출력중입니다. 기다려주세요");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("이미 물건이 나오고 있습니다. 동전 반환이 안됩니다.");
	}

	@Override
	public void turnCrank() {
		System.out.println("이미 레버를 돌렸습니다.");
	}

	@Override
	public void dispense() {
		System.out.println("물건이 나오는 중입니다.");
		if(gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		}else if(gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

}
