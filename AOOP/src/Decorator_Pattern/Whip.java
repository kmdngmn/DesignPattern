package Decorator_Pattern;

public class Whip extends Decorator {

	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",휘핑추가";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.3;
	}

}
