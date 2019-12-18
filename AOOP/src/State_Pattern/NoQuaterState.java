package State_Pattern;

public class NoQuaterState implements State {

	GumballMachine gumballMachine;

	public NoQuaterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;

	}

	@Override
	public void insertQuarter() {
		// TODO Auto-generated method stub
		System.out.println("동전을 넣었습니다.");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {

		System.out.println("동전을 넣어주세요");
	}

	@Override
	public void turnCrank() {
		System.out.println("동전을 넣어주세요");

	}

	@Override
	public void dispense() {
		System.out.println("동전을 넣어주세요");

	}
}
