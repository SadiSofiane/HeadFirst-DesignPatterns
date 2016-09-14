package headfirst.designpatterns.observer;

/**
 * Created by Sofiane Sadi on 9/14/16.
 */
// This display implements Observer so it can get changes from the WeatherData object.
// It also implements DisplayElement, because our API is going to require all display elements to implement this interface.
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    // The constructor passed the weatherData object (the Subject) and we use it to register the display as an observer.
    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    // When update() is called, we save the temp and humidity and call display().
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    // The display method just prints out the most recent temp and humidity.
    @Override
    public void display() {
        System.out.println("Current conditions: " + this.temperature + "F degrees and " + this.humidity + "% humidity");
    }

}
