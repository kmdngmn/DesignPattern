package Decorator_Pattern_mid;

abstract class Beverage {

	String description = "";

	public abstract double cost();

	public String getDescription() {
		return description;
	}

}

class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "다크로스트";
	}

	@Override
	public double cost() {
		return 1.3;
	}

}

class HouseBlend extends Beverage {

	public HouseBlend() {
		// TODO Auto-generated constructor stub
		description = "하우스블렌드";
	}

	@Override
	public double cost() {
		return 1.5;
	}

}

abstract class Decorator extends Beverage {

	public abstract String getDescription();

}

class Mocha extends Decorator {

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

		return beverage.cost() + 0.1;
	}

}

class Whip extends Decorator {

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
		return beverage.cost() + 0.2;
	}

}

abstract class Decorator2 extends Decorator {

	public abstract String getDescription();

}

class Cold extends Decorator2 {

	Beverage beverage;

	public Cold(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ",콜드드링크 +0.1 추가";

	}

	public double cost() {
		return beverage.cost() + .1;
	}

}

class Hot extends Decorator2 {

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

public class Main {
	public static void main(String[] args[]) {

		Beverage b1 = new DarkRoast();
		System.out.println(b1.getDescription() + " : " + b1.cost());

		Beverage b2 = new DarkRoast();
		b2 = new Whip(b2);
		b2 = new Mocha(b2);
		b2 = new Cold(b2);
		System.out.println(b2.getDescription() + " : " + b2.cost());

		Beverage b3 = new HouseBlend();
		b3 = new Whip(b3);
		b3 = new Mocha(b3);
		b3 = new Hot(b3);
		System.out.println(b3.getDescription() + " : " + b3.cost());

	}
}
