package Decorator_Pattern_1;

import Decorator_Pattern_2.Beverage;
import Decorator_Pattern_2.DarkRoast;
import Decorator_Pattern_2.HouseBlend;
import Decorator_Pattern_2.Mocha;
import Decorator_Pattern_2.Whip;

//사진에 문제참고
//기존 description, cost에서 size속성 추가 예제
public class StarbuzzCoffee {

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
		
		System.out.println("주문완료");

	}

}
