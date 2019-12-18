package Decorator_Pattern_1;

public class DarkRoast extends Beverage {

	public DarkRoast() {

		description = "다크로스트1.5 ";

	}

	@Override
	public double cost() {
		return 1.5;
	}

}
