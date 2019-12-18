package Decorator_Pattern_2;

//Component
public abstract class Beverage {

	String description = "";

	public abstract double cost();

	public String getDescription() {
		return description;
	}

	public static String TALL = "tall";
	public static String GRANDE = "grande";
	public static String VENTI = "venti";

	String size = "";

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
