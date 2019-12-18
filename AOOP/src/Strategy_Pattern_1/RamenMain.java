package Strategy_Pattern_1;

class Ramen {

	Strategy strategy = new GeneralRamen();

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void cook() {
		strategy.cook();
	}

}

interface Strategy {
	public void cook();
}

class GeneralRamen implements Strategy {

	@Override
	public void cook() {
		System.out.println("일반라면");
	}

}

class CheeseRamen implements Strategy {

	@Override
	public void cook() {

		System.out.println("치즈라면");
	}

}

class MandooRamen implements Strategy {

	@Override
	public void cook() {
		System.out.println("만두라면");
	}

}

public class RamenMain {

	public static void main(String[] args) {

		Ramen r1 = new Ramen();
		r1.cook();

		r1.setStrategy(new CheeseRamen());
		r1.cook();

		r1.setStrategy(new MandooRamen());
		r1.cook();

	}
}
