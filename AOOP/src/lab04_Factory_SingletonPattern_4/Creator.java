package lab04_Factory_SingletonPattern_4;

public abstract class Creator {

	public abstract Product windowCreator(String type, String title, int x, int y, int width, int height);
	
}
