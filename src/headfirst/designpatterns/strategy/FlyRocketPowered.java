package headfirst.designpatterns.strategy;

/**
 * Created by Sofiane Sadi on 9/13/16.
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket !");
    }
}
