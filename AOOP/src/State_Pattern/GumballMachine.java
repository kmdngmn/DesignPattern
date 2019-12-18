package State_Pattern;

public class GumballMachine {

	private State soldOutState;
	private State noQuarterState;
	private State hasQuarterState;
	private State soldState;

	State state = soldOutState;
	int count = 0;

	public GumballMachine(int numberGumballs) {

		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuaterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);

		this.count = numberGumballs;

		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}

	public void insertQuarter() {
		state.insertQuarter();
	}

	public void ejectQuarter() {
		state.ejectQuarter();
	}

	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}

	void releaseBall() {
		System.out.println("A Gumball Comes Rolling Out The Slot...");

		if (count != 0) {
			count -= 1;
		}
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public int getCount() {
		return count;
	}

}
