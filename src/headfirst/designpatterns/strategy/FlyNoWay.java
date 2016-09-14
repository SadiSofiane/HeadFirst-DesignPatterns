package headfirst.designpatterns.strategy;

/**
 * Created by Sofiane Sadi on 9/13/16.
 */
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can't fly");
    }
}
