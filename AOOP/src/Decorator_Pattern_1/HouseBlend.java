package Decorator_Pattern_1;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		// TODO Auto-generated constructor stub
		description = "하우스블렌드1.0 ";
	}

	@Override
	public double cost() {
		return 1.0;
	}

}
