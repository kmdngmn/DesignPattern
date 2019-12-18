package Decorator_Pattern;

public class Mocha extends Decorator {

	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {

		return beverage.getDescription() + ",모카추가";
	}

	@Override
	public double cost() {

		return beverage.cost() + 0.2;
	}

}

/*
 * 흐름, 한라인 추가
 */
