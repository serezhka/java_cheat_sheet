package com.github.serezhka.pattern;

/**
 * Adapter pattern works as a bridge between two incompatible interfaces.
 * This type of design pattern comes under structural pattern as this pattern combines the capability of two independent interfaces.
 *
 * @author Sergei Fedorov (serezhka@xakep.ru)
 * @since 26.06.2017
 */
public class AdapterPatternDemo {

    private interface Attacker {
        void attack();

        void move();
    }

    private static class Robot {
        public void handSmash() {
            System.out.println("Robot::handSmash()");
        }

        public void walk() {
            System.out.println("Robot::walk()");
        }
    }

    private static class RobotAttackerAdapter implements Attacker {
        private final Robot robot;

        private RobotAttackerAdapter(Robot robot) {
            this.robot = robot;
        }

        @Override
        public void attack() {
            robot.handSmash();
        }

        @Override
        public void move() {
            robot.walk();
        }
    }

    public static void main(String[] args) {
        Attacker attacker = new RobotAttackerAdapter(new Robot());
        System.out.println("Attacker::attack()");
        attacker.attack();
        System.out.println("Attacker::move()");
        attacker.move();
    }
}
