package Decorator_Pattern_2;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "다크로스트1.0 ";
	}

	@Override
	public double cost() {
		return 1.0;
	}

}
