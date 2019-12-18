
public interface Subject {

	public void addObserver(Observer adob);

	public void removeObserver(Observer rmob);

	public void notifyObservers();

}
