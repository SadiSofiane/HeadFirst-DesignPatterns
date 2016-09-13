package headfirst.designpatterns.adapter;

/**
 * Created by Sofiane Sadi on 9/13/16.
 */
public class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("Squeak");
    }
}
