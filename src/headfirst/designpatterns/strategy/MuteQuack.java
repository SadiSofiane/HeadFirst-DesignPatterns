package headfirst.designpatterns.strategy;

/**
 * Created by Sofiane Sadi on 9/13/16.
 */
public class MuteQuack implements QuackBehavior {

    public void quack() {
        System.out.println("<< Silence >>");

    }
}
