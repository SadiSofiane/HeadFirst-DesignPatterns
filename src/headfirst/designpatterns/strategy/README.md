# The strategy pattern
## Definition
The Strategy Pattern defines a family of algorithms encapsulates each one, and make them interchangeable. 
Strategy lets the algorithm vary independently from clients that use it.

## UML representation
    @startuml

    title Encapsuled behaviors

    package "Client" {
        class Duck {
            +FlyBehavior flyBehavior
            +QuackBehavior quackBehavior
            +swim()
            +display()
            +performQuack()
            +performFly()
            +setFlyBehavior()
            +setQuackBehavior()
        }
        class MallardDuck {
            +display()
        }

        class RedheadDuck {
            +display()
        }

        class RubberDuck {
            +display()
        }

        class DecoyDuck {
            +display()
        }

        MallardDuck --|> Duck: IS A
        RedheadDuck --|> Duck: IS A
        RubberDuck --|> Duck: IS A
        DecoyDuck --|> Duck: IS A
    }


    package "Encapsulated fly behavior" {
        interface FlyBehavior {
            +fly()
        }

        class FlyWithWings {
            +fly()
        }

        class FlyNoWay {
            +fly()
        }

        FlyWithWings ..|> FlyBehavior : IMPLEMENTS
        FlyNoWay ..|> FlyBehavior : IMPLEMENTS
    }

    Duck --> FlyBehavior: HAS A

    package "Encapsulated quack behavior" {
        interface QuackBehavior {
            +quack()
        }

        class Quack {
            +quack()
        }

        class Squeak {
            +quack()
        }

        class MuteQuack {
            +quack()
        }

        Quack ..|> QuackBehavior : IMPLEMENTS
        Squeak ..|> QuackBehavior : IMPLEMENTS
        MuteQuack ..|> QuackBehavior : IMPLEMENTS
    }

    Duck --> QuackBehavior: HAS A

    @enduml


![UML representation](uml_adapter_dp.png)

## When
**Identify the aspects of your application that vary and separate them from what stays the same.**
If some aspect of the code is changing, then you have a behavior that needs to be pulled out and separated from all the non-changing stuff.
To deal with it take the parts that vary and encapsulate them, so that later you can alter or extend the parts that vary without affecting those that don't.
The result are fewer unintended consequences from code changes and more flexibility in your systems!

This is the basis for almost every design patterns.


## How to use the strategy pattern

### The problem:

    @startuml
        title Interface - Wrong: Code duplicate
        
        interface Quackable {
            +quack()
        }
        
        interface Flyable {
            +fly()
        }
        
        class Duck {
            +display()
        }
        
        class MallardDuck {
            +quack()
            +fly()
            +display()
        }

        class RedheadDuck {
            +quack()
            +fly()
            +display()
        }

        class RubberDuck {
            +quack()
            +display()
        }

        class DecoyDuck {
            +display()
        }
        
        MallardDuck ..|> Quackable
        MallardDuck ..|> Flyable
        RedheadDuck ..|> Quackable
        RedheadDuck ..|> Flyable
        RubberDuck ..|> Quackable
        
        MallardDuck --|> Duck
        RubberDuck --|> Duck
        DecoyDuck --|> Duck
        RedheadDuck --|> Duck

    @enduml
![UML representation](uml_interface_code_duplicate.png)
Wrong: Code duplicate !

### The solution

**Program to an interface, not an implementation**

The solution:

    @startuml
    
        title Program to an interface
        
        interface QuackBehavior {
            +quack()
        }
        
        interface FlyBehavior {
            +fly()
        }
        
        class FlyWithWings {
            +fly()
        }
        
        class FlyNoWay {
            +fly()
        }
        
        class Quack {
            +quack()
        }
        
        class Squeak {
            +quack()
        }
        
        class MuteQuack {
            +quack()
        }
        
        Quack ..> QuackBehavior
        Squeak ..> QuackBehavior
        MuteQuack ..> QuackBehavior
        
        FlyWithWings ..> FlyBehavior
        FlyNoWay ..> FlyBehavior

    @enduml
![UML representation](uml_program_to_an_interface.png)


Use interface to represent changing behaviors.


Programming to an implementation would be:
```java
Dog d = new Dog();
d.bark();
```

Programming to an interface / supertype would be:
```java
Animal animal = new Dog();
animal.makeSound
```

```java
a = getAnimal();
a.makeSound();
```
Advantage:
We don't know what the actual animal subtype is, we only need to invoke makeSound():


### Composition vs Inheritance
HAS-A = Composition
IS-A = Inheritance

**Favor composition over inheritance**
Composition allow more flexibility. Let you encapsulate a family of algorithms into their own set of classes and **change behavior at runtime**.
Composition is used in many design patterns.