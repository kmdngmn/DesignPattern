package Command_Pattern_1;

public class CeilingFan {

	public static final int HIGH = 3;
	public static final int MEDIUN = 2;
	public static final int LOW = 1;
	public static final int OFF = 0;

	String location;

	int speed;

	public CeilingFan(String location) {
		this.location = location;
		speed = OFF;
	}

	public void high() {
		speed = HIGH;
		System.out.println("speed : " + speed);
	}

	public void medium() {
		speed = MEDIUN;

		System.out.println("speed : " + speed);
	}

	public void low() {
		speed = LOW;

		System.out.println("speed : " + speed);
	}

	public void off() {
		speed = OFF;

		System.out.println("speed : " + speed);
	}

	public int getSpeed() {
		return speed;
	}
}
