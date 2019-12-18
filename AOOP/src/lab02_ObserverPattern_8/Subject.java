package lab02_ObserverPattern_8;

public interface Subject {

	public void addObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver();

}
