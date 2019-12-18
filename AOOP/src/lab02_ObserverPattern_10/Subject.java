package lab02_ObserverPattern_10;

public interface Subject {

	public void addObserver(Observer o);

	public void removeObsever(Observer o);

	public void notifyObserver();

}
