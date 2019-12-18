package Strategy_Pattern;

class Duck {

	void swim() {
		System.out.println("수영");
	}

	void diplay() {
		System.out.println("오리");
	}

}

interface Flyable {
	void fly();
}

interface Quackable {
	void quack();
}

class MallardDuck extends Duck implements Flyable, Quackable {
	void display() {
		System.out.println("말라드덕");
	}

	@Override
	public void quack() {
		System.out.println("말라드덕 꽥");
	}

	@Override
	public void fly() {
		System.out.println("말라드덕 날다");
	}

}

class RedheadDuck extends Duck implements Flyable, Quackable {
	void display() {
		System.out.println("레드헷덕");
	}

	@Override
	public void quack() {
		System.out.println("레드헷덕 꽥");
	}

	@Override
	public void fly() {
		System.out.println("레드헷덕 날다");
	}

}

class RubberDuck extends Duck implements Quackable {
	void quak() {
		System.out.println("러버드덕 꾸이익");
	}

	void display() {
		System.out.println("러버덕");
	}

	@Override
	public void quack() {
		System.out.println("러버덕 꽥꽥꽥 꾸시");
	}

}

public class DuckMain {

	public static void main(String[] args) {

		Duck d1 = new Duck();
		MallardDuck d2 = new MallardDuck();
		RedheadDuck d3 = new RedheadDuck();
		RubberDuck d4 = new RubberDuck();

		d1.diplay();
		d2.diplay();
		d3.diplay();
		d4.diplay();

//		d1.quack();
		d2.quack();
		d3.quack();
		d4.quack();

//		d1.fly();
		d2.fly();
		d3.fly();
//		d4.fly();

	}

}
