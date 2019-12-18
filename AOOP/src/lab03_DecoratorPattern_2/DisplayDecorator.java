package lab03_DecoratorPattern_2;

import javax.swing.*;

public abstract class DisplayDecorator extends Display {
	DisplayDecorator(Display display, int width, int height) {
		super(width, height);
	}

	public abstract JPanel create();

	public abstract void show();

}
