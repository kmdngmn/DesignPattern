package State_Pattern;

public class HasQuarterState implements State {
	GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine) {

		this.gumballMachine = gumballMachine;

	}

	@Override
	public void insertQuarter() {
		System.out.println("이미 동전이 있습니다");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("동전을 반환합니다.");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("레버를 돌렸습니다.");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

	@Override
	public void dispense() {
		System.out.println("레버를 돌려주세요");
	}
}
