package headfirst.designpatterns.observer;

/**
 * Created by Sofiane Sadi on 9/14/16.
 */
public interface Subject {
    // Both registerObserver and removeObserver use an Observer
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
