package Singleton_Pattern;

public class Singleton {

	private volatile static Singleton inst;

	private Singleton() {

	}

	public static Singleton getInstance() {

		if (inst == null) {

			synchronized (Singleton.class) {

				if (inst == null) {
					inst = new Singleton();
				}

			}

		}

		return inst;

	}

}
