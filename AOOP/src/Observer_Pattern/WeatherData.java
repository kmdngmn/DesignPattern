package Observer_Pattern;

import java.util.ArrayList;

//Subject
public class WeatherData implements Subject {

	private ArrayList<Observer> observers;

	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {

		observers = new ArrayList<Observer>();
	}

	@Override
	public void addObserver(Observer o) {

		observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {

		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}

	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < observers.size(); i++) {

			Observer observer = observers.get(i);

			observer.update(temperature, humidity, pressure);

		}
	}

	public void measurementsChanged() {
		notifyObserver();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {

		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;

		measurementsChanged();

	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}
