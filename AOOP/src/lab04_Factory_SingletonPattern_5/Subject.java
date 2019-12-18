package lab04_Factory_SingletonPattern_5;

public interface Subject {

	public void addObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver();

}
