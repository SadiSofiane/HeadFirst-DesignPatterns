package headfirst.designpatterns.observer;

/**
 * Created by Sofiane Sadi on 9/14/16.
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
        HeatIndexDisplay heatDisplay = new HeatIndexDisplay(weatherData);

        // Simulate new weather
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 28.1f);
    }
}
