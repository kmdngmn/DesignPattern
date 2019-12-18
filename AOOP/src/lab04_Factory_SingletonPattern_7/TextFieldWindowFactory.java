package lab04_Factory_SingletonPattern_7;

public class TextFieldWindowFactory extends Creator {

	private volatile static TextFieldWindowFactory inst;

	private TextFieldWindowFactory() {
	}

	public static TextFieldWindowFactory getInstance() {

		if (inst == null) {
			synchronized (TextFieldWindowFactory.class) {
				if (inst == null) {
					inst = new TextFieldWindowFactory();
				}
			}
		}
		return inst;
	}

	@Override
	public Product createWindow(String title, int x, int y, int width, int height) {

		return new TextFieldWindow(title, x, y, width, height);

	}

}
