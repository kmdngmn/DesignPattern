package lab04_CommandPattern;

import javax.swing.JPanel;

public abstract class Product extends FrameWindow implements Observer {

	public Product() {
	}

	public abstract JPanel createPanel(int width, int height);

	public abstract void updateText(String msg);

}
