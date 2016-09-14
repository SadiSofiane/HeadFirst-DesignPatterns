package headfirst.designpatterns.strategy;

/**
 * Created by Sofiane Sadi on 9/13/16.
 */
public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}