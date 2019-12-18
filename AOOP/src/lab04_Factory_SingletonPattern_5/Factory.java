package lab04_Factory_SingletonPattern_5;

public class Factory extends Creator {

	private static volatile Factory inst;
	private Product pro;

	private Factory() {
	}

	public static Factory getInstance() {

		if (inst == null) {

			synchronized (Factory.class) {

				if (inst == null) {
					inst = new Factory();
				}
			}
		}
		return inst;
	}

	@Override
	public Product createWindow(String type, String title, int x, int y, int width, int height) {

		if (type.equals("JTextField")) {
			pro = new TextFieldWindow(title, x, y, width, height);
		} else if (type.equals("JLabel")) {
			pro = new LabelWindow(title, x, y, width, height);
		} else if (type.equals("JLabel2")) {
			pro = new LabelWindow2(title, x, y, width, height);
		} else {
			pro = null;
		}

		return pro;

	}

}
