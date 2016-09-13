package headfirst.designpatterns.oodesignprinciples;

import com.sun.media.sound.ModelDestination;

/**
 * Created by Sofiane Sadi on 9/13/16.
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
