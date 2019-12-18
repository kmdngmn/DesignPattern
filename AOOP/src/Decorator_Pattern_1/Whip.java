package Decorator_Pattern_1;

public class Whip extends Decorator {

	Beverage beverage;

	public Whip(Beverage beverage) {

		this.beverage = beverage;

	}

	@Override
	public String getDescription() {

		return beverage.getDescription() + "휘핑추가 ";

	}

	@Override
	public String getSize() {
		return beverage.getSize();
	}

	@Override
	public double cost() {
		double cost = beverage.cost();

		if (getSize() == Beverage.TALL) {

			cost += 0.10;
		} else if (getSize() == Beverage.GRANDE) {

			cost += 0.15;
		} else if (getSize() == Beverage.VENTI) {

			cost += 0.20;
		}

		return cost;
	}

}
