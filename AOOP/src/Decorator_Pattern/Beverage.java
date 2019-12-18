package Decorator_Pattern;

//Component
public abstract class Beverage {

	String description = "";

	public abstract double cost();

	public String getDescription() {
		return description;
	}

}
