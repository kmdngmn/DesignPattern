package lab02_ObserverPattern_9;

public interface Subject {

	public void addObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver();

}
