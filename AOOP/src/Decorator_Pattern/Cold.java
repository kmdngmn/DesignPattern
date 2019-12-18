package Decorator_Pattern;

public class Cold extends Decorator2 {

	Beverage beverage;

	public Cold(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ",콜드드링크 +0.2 추가";

	}

	public double cost() {
		return beverage.cost() + 0.2;
	}

}
