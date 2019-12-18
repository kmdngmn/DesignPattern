package lab04_Factory_SingletonPattern_4;

public class CreateWindow extends Creator {

	private volatile static CreateWindow inst;

	private Product pro;

	private CreateWindow() {
	}

	public static CreateWindow getInstance() {

		if (inst == null) {
			synchronized (CreateWindow.class) {

				if (inst == null) {
					inst = new CreateWindow();
				}

			}
		}
		return inst;
	}

	@Override
	public Product windowCreator(String type, String title, int x, int y, int width, int height) {
		if (type.equals("JTextFiled")) {
			pro = new TextFieldWindow(title, x, y, width, height);
		} else if (type.equals("JLabel")) {
			pro = new LabelWindow(title, x, y, width, height);
		}

		return pro;
	}

}
