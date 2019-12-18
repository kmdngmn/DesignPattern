public abstract class ObserverWindow extends FrameWindow implements Observer {
    ObserverWindow(String title, int x, int y, int width, int height) {
        super(title, x, y, width, height);
    }

    @Override
    public void update(int n) {
        updateText("" + n);
    }

    public abstract void updateText(String s);
}
