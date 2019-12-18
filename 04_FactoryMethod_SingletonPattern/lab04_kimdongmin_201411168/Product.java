import javax.swing.JPanel;

public abstract class Product extends FrameWindow implements Observer {

	public Product(String title, int x, int y, int width, int height) {
		super(title, x, y, width, height);
	}

	public abstract JPanel createPanel(int width, int height);

	public abstract void updateText(String msg);

}
