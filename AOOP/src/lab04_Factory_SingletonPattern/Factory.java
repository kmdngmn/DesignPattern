package lab04_Factory_SingletonPattern;

public abstract class Factory {

	public abstract Product createWindow(String type, String title, int x, int y, int width, int height);

}
