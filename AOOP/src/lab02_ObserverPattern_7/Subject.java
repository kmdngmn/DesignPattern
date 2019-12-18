package lab02_ObserverPattern_7;

public interface Subject {

	public void addObserver(Observer o);
	
	public void removeObserver(Observer o);
	
	public void notifyObserver();
	
}
