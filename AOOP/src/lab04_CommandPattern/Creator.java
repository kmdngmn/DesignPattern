package lab04_CommandPattern;

public abstract class Creator {
	public abstract Product createWindow(String title, int x, int y, int width, int height); // LabelWindow, TextFieldWindow 를 생성하는 팩토리 메소드

}
