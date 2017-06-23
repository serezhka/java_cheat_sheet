package com.github.serezhka.pattern;

import java.util.Random;

/**
 * Factory design pattern is used when we have a super class with multiple sub-classes and based on input,
 * we need to return one of the sub-class.
 * This pattern take out the responsibility of instantiation of a class from client program to the factory class.
 *
 * @author Sergei Fedorov (serezhka@xakep.ru)
 * @since 23.06.2017
 */
public class FactoryPatternDemo {

    private static abstract class Gun {
        private final int power;

        protected Gun(int power) {
            this.power = power;
        }

        public void shoot() {
            System.out.println(getClass().getSimpleName() + " shoots with power " + power);
        }
    }

    private static class BFGun extends Gun {
        public BFGun(int power) {
            super(power);
        }
    }

    private static class DefaultGun extends Gun {
        public DefaultGun(int power) {
            super(power);
        }
    }

    private static class GunFactory {
        public static Gun createGun(int power) {
            if (power > 100) {
                return new BFGun(power);
            } else return new DefaultGun(power);
        }
    }

    public static void main(String[] args) {
        GunFactory.createGun(new Random().nextInt(200)).shoot();
    }
}
