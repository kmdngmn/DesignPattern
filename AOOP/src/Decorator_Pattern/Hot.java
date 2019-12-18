package Decorator_Pattern;

public class Hot extends Decorator2 {

	Beverage beverage;

	public Hot(Beverage beverage) {

		this.beverage = beverage;

	}

	public String getDescription() {

		return beverage.getDescription() + ",핫드링크 -0.1할인";

	}

	public double cost() {
		return beverage.cost() - 0.1;
	}

}
