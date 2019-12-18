package Observer_Pattern;

public class WeatherStation {

	public static void main(String[] args) {

		WeatherData weatherData1 = new WeatherData();

		CurrentConditionsDisplay1 c1 = new CurrentConditionsDisplay1(weatherData1);

		weatherData1.setMeasurements(20, 70, 55);

		System.out.println();
		
		WeatherData weatherData2 = new WeatherData();

		CurrentConditionsDisplay2 c2 = new CurrentConditionsDisplay2(weatherData2);

		weatherData2.setMeasurements(18, 50, 45);

	}

}
