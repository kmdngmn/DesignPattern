package Decorator_Pattern_2;

public class Main {

	public static void main(String[] args) {

		Beverage b1 = new HouseBlend();
		b1.setSize("tall");
		b1 = new Mocha(b1);
		System.out.println(b1.getDescription() + ", " + b1.getSize() + "사이즈, " + b1.cost());

		Beverage b2 = new DarkRoast();
		b2.setSize("grande");
		b2 = new Whip(b2);
		System.out.println(b2.getDescription() + ", " + b2.getSize() + "사이즈, " + b2.cost());

		Beverage b3 = new DarkRoast();
		b3.setSize("venti");
		b3 = new Whip(b3);
		b3 = new Mocha(b3);
		System.out.println(b3.getDescription() + ", " + b3.getSize() + "사이즈, " + b3.cost());

	}

}
