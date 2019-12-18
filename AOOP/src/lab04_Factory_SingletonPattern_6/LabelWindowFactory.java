package lab04_Factory_SingletonPattern_6;

public class LabelWindowFactory extends Creator {

	private volatile static LabelWindowFactory inst;

	private LabelWindowFactory() {
	}

	public static LabelWindowFactory getInstance() {

		if (inst == null) {
			synchronized (LabelWindowFactory.class) {
				if (inst == null) {
					inst = new LabelWindowFactory();
				}
			}
		}
		return inst;
	}

	@Override
	public Product creatWindow(String title, int x, int y, int width, int height) {

		return new LabelWindow(title, x, y, width, height);
	}
}
