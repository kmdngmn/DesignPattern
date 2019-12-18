package lab04_Factory_SingletonPattern_3;

public abstract class Creator { 

	public abstract Product createWindow(String type, String title, int x, int y, int width, int height);
	
}
