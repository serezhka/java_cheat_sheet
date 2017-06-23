package com.github.serezhka.pattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Observer Pattern is one of the behavioral design pattern.
 * Observer design pattern is useful when you are interested in the state of an object
 * and want to get notified whenever there is any change.
 * In observer pattern, the object that watch on the state of another object are called Observer
 * and the object that is being watched is called Subject (Observable).
 *
 * @author Sergei Fedorov (serezhka@xakep.ru)
 * @since 22.06.2017
 */
public class ObserverPatternDemo {

    private static class Zoo extends Observable {
        public void addAnimal(Object animal) {
            setChanged();
            notifyObservers(animal);
        }
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addObserver((o, arg) -> System.out.println("New animal: " + arg));
        zoo.addObserver(new Observer() {

            private int animalCount;

            @Override
            public void update(Observable o, Object arg) {
                System.out.println("Total animals: " + ++animalCount);
            }
        });

        zoo.addAnimal("Cat");
        zoo.addAnimal("Dog");
    }
}
