package SOLID;

class Rectangle {
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getPeriment() {
		return 2 * (width + height);
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}

class Square extends Rectangle {

	public Square(int width) {
		super(width, width);
	}

	public void setWidth(int w) {
		super.setWidth(w);
		super.setHeight(w);
	}

	public void setHeight(int h) {
		super.setWidth(h);
		super.setHeight(h);
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle r = new Rectangle(3, 5);
		System.out.println(r.getPeriment());
		
		Square s = new Square(5);
		System.out.println(s.getPeriment());
		
		r = s;
		r.setHeight(3);
		r.setWidth(5);
		
		System.out.println(r.getPeriment());
		
	}

}
