package headfirst.designpatterns.observer;

import java.util.ArrayList;

/**
 * Created by Sofiane Sadi on 9/14/16.
 */
// Weather data implements the Subject interface.
public class WeatherData implements Subject {
    // Array list to hold the observers.
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    // Create Array list of observer in the constructor.
    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    // When an observer registers, we just add it to the end of the list.
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    // Likewise when an observer whants to unregister, we just take it off the list.
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0 ) {
            observers.remove(i);
        }
    }

    // FUN PART: This is where we tell all the observers about the state.
    // Because they are all Observers, we know they all implement update(), so we know how to notify them.
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    // We notify the Observers when we get updated measurements from the Weather Station.
    public void measurementsChanged() {
        notifyObservers();
    }

    // While we wanted to ship a nice little weather station with each book, the publisher wouldn't got for it.
    // So rather than reading actual weather data off a device, we're going to use this method to test our display elements.
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
