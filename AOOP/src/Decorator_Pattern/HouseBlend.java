package Decorator_Pattern;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		// TODO Auto-generated constructor stub
		description = "하우스블렌드";
	}
	
	@Override
	public double cost() {
		return 1.5;
	}

}
