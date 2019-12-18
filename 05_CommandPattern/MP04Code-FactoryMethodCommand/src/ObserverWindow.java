public abstract class ObserverWindow extends FrameWindow implements Observer {
    ObserverWindow() {
        super();
    }

    @Override
    public void update(int n) {
        updateText("" + n);
    }

    public abstract void updateText(String s);
}
