package lab04_Factory_SingletonPattern_2;

import javax.swing.JPanel;

public abstract class Product extends FrameWindow implements Observer {

	public Product(String type, String title, int x, int y, int width, int height) {
		super(type, title, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public abstract void updateText(String msg);

	public abstract JPanel createPanel(int width, int height);

}
