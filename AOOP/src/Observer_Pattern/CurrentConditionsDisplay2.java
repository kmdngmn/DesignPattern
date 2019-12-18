package Observer_Pattern;

//Observer
public class CurrentConditionsDisplay2 implements Observer, DisplayElements {

	private float temperature;
	private float humidity;
	private float pressure;

	private Subject weatherData;

	public CurrentConditionsDisplay2(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.addObserver(this);
	}

	@Override
	public void display() {

		System.out.println("temperature : " + temperature + "도" + "\nhumidity : " + humidity + "%" + "\npressure : "
				+ pressure + "J");

	}

	@Override
	public void update(float temperature, float humidity, float pressure) {

		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();

	}

}
