package lab04_Factory_SingletonPattern;

public class FactoryConcrete extends Factory {

	private volatile static FactoryConcrete inst;

	private Product pro;

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
			pro = new TextFieldWindow(title, x, y, width, height);
		} else if (type.equals("Label")) {
			pro = new LabelWindow(title, x, y, width, height);
		} else {
			pro = null;
		}
		return pro;
	}

}
