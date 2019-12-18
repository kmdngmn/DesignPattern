package lab02_ObserverPattern_11;

public interface Subject {
	
	public void addObserver(Observer o);
	
	public void removeObserver(Observer o);
	
	public void notifyObserver();

}
