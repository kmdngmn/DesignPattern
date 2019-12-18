public class ObserverWindowFactory extends AbstractObserverWindowFactory {
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
