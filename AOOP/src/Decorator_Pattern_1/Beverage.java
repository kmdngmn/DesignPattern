package Decorator_Pattern_1;

public abstract class Beverage {

	String description = "";

	public String getDescription() {
		return description;
	}

	public abstract double cost();

	String size = "";

	public String getSize() {
		return size;
	}

	public static String TALL = "tall";
	public static String GRANDE = "grande";
	public static String VENTI = "venti";

	public void setSize(String size) {

		this.size = size;
	}

}
