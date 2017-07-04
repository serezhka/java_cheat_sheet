package com.github.serezhka.pattern;

/**
 * Command pattern is a data driven design pattern and falls under behavioral pattern category.
 * A request is wrapped under an object as command and passed to invoker object.
 * Invoker object looks for the appropriate object which can handle this command
 * and passes the command to the corresponding object which executes the command.
 *
 * @author Sergei Fedorov (serezhka@xakep.ru)
 * @since 04.07.2017
 */
public class CommandPatternDemo {

    private interface Device {
        void on();

        void off();
    }

    private static class TV implements Device {
        @Override
        public void on() {
            System.out.println("TV is on!");
        }

        @Override
        public void off() {
            System.out.println("TV is off!");
        }
    }

    private interface Command {
        void execute();
    }

    private static class TurnDeviceOn implements Command {
        private final Device device;

        private TurnDeviceOn(Device device) {
            this.device = device;
        }

        @Override
        public void execute() {
            device.on();
        }
    }

    private static class TurnDeviceOff implements Command {
        private final Device device;

        private TurnDeviceOff(Device device) {
            this.device = device;
        }

        @Override
        public void execute() {
            device.off();
        }
    }

    public static void main(String[] args) {
        Device tv = new TV();
        Command turnTVOn = new TurnDeviceOn(tv);
        Command turnTVOff = new TurnDeviceOff(tv);
        turnTVOn.execute();
        turnTVOff.execute();
    }
}
