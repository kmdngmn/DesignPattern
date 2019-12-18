package lab04_Factory_SingletonPattern_2;

public class FactoryConcrete extends Creator {

	private volatile static FactoryConcrete inst;

	private FactoryConcrete() {
	}

	public static FactoryConcrete getInstance() {
		if (inst == null) {
			synchronized (FactoryConcrete.class) {
				if (inst == null) {
					inst = new FactoryConcrete();
				}
			}
		}
		return inst;
	}

	@Override
	public Product createWindow(String type, String title, int x, int y, int width, int height) {

		if (type.equals("TextField")) {

			return new TextFieldWindow(type,title, x, y, width, height);

		} else if (type.equals("Label")) {

			return new LabelWindow(type, title, x, y, width, height);
		} else {
			return null;
		}

	}

}
