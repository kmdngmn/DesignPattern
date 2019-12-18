package Observer_Pattern;

//Observer
public class CurrentConditionsDisplay1 implements Observer, DisplayElements {

	private float temperature;
	private float humidity;
	
	private Subject weatherData;
	
	public CurrentConditionsDisplay1(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.addObserver(this);
	}
	
	@Override
	public void display() {

		System.out.println("temperature : " + temperature + "도" + "\nhumidity : " + humidity + "%");
		
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {

		this.temperature = temperature;
		this.humidity = humidity;
		display();
		
	}

}
