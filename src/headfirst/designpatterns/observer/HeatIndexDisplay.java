package headfirst.designpatterns.observer;

/**
 * Created by Sofiane Sadi on 9/14/16.
 */
// This display implements Observer so it can get changes from the WeatherData object.
// It also implements DisplayElement, because our API is going to require all display elements to implement this interface.
public class HeatIndexDisplay implements Observer, DisplayElement {
    private Subject weatherData;
    private float heatIndex;

    // The constructor passed the weatherData object (the Subject) and we use it to register the display as an observer.
    public HeatIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    // When update() is called, we call the computeHeatIndex() function to get the heat index then we call display().
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.heatIndex = computeHeatIndex(temp, humidity);
        display();
    }

    // The display method just prints out the heat index.
    @Override
    public void display() {
        System.out.println("Heat index is " + this.heatIndex);
    }

    // Calculate the heat index from the temperature and the humidity
    private float computeHeatIndex(float t, float rh) {
        float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
                (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
                (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
        return index;
    }
}
