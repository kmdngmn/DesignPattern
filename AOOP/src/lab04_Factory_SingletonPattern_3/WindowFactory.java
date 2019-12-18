package lab04_Factory_SingletonPattern_3;

public class WindowFactory extends Creator {

	private Product pro;

	private volatile static WindowFactory instance;

	private WindowFactory() {
	}

	public static WindowFactory getInstance() {
		if (instance == null) {
			synchronized (WindowFactory.class) {
				if (instance == null) {
					instance = new WindowFactory();
				}
			}
		}
		return instance;
	}

	@Override
	public Product createWindow(String type, String title, int x, int y, int width, int height) {

		if (type.equals("TextField")) {
			pro = new TextFieldWindow(title, x, y, width, height);
		} else if (type.equals("Label")) {
			pro = new LabelWindow(title, x, y, width, height);
		} else {

			pro = null;
		}

		return pro;
	}

}
