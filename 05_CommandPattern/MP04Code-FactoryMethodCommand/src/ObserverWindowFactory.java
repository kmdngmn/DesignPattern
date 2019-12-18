public class ObserverWindowFactory extends AbstractObserverWindowFactory {
    private volatile static ObserverWindowFactory inst;
    private ObserverWindowFactory() { }
    public static ObserverWindowFactory getInstance() {
        if (inst == null) {
            synchronized (ObserverWindowFactory.class) {
                if (inst == null) {
                    inst = new ObserverWindowFactory();
                }
            }
        }
        return inst;
    }

    public ObserverWindow create(String type, String title, int x, int y, int width, int height) {
        if (type.compareTo("TextFieldWindow") == 0) {
            return new TextFieldWindow(title, x, y, width, height);
        }
        else if (type.compareTo("LabelWindow") == 0) {
            return new LabelWindow(title, x, y, width, height);
        }
        return null;
    }
}
