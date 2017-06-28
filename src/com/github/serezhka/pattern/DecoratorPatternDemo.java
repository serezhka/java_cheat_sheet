package com.github.serezhka.pattern;

/**
 * Decorator pattern allows to add new functionality to an existing object without altering its structure.
 *
 * @author Sergei Fedorov (serezhka@xakep.ru)
 * @since 26.06.2017
 */
public class DecoratorPatternDemo {
    private interface Pizza {
        String getDescription();

        double getCost();
    }

    private static class PlainPizza implements Pizza {

        public PlainPizza() {
            System.out.println("Adding dough");
        }

        @Override
        public String getDescription() {
            return "Plain pizza";
        }

        @Override
        public double getCost() {
            return 4.00;
        }
    }

    private static abstract class ToppingDecorator implements Pizza {

        protected final Pizza pizza;

        public ToppingDecorator(Pizza pizza) {
            this.pizza = pizza;
        }

        @Override
        public String getDescription() {
            return pizza.getDescription();
        }

        @Override
        public double getCost() {
            return pizza.getCost();
        }
    }

    private static class SauceTopping extends ToppingDecorator {
        public SauceTopping(Pizza pizza) {
            super(pizza);
            System.out.println("Adding sauce");
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", Sause";
        }

        @Override
        public double getCost() {
            return super.getCost() + .50;
        }
    }

    private static class MozzarellaTopping extends ToppingDecorator {
        public MozzarellaTopping(Pizza pizza) {
            super(pizza);
            System.out.println("Adding mozzarella");
        }

        @Override
        public String getDescription() {
            return super.getDescription() + ", Mozzarella";
        }

        @Override
        public double getCost() {
            return super.getCost() + .40;
        }
    }

    public static void main(String[] args) {
        Pizza tastyPizza = new SauceTopping(new MozzarellaTopping(new PlainPizza()));
        System.out.println("Ingredients: " + tastyPizza.getDescription());
        System.out.println("Cost: " + tastyPizza.getCost());
    }
}
