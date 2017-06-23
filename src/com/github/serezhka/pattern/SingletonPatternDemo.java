package com.github.serezhka.pattern;

/**
 * @author Sergei Fedorov (serezhka@xakep.ru)
 * @since 23.06.2017
 */
public class SingletonPatternDemo {

    /**
     * Static field
     * <p>
     * + Simple
     * + Thread safe
     */
    public static final Object INSTANCE = new Object();

    /**
     * On Demand Holder idiom
     * <p>
     * + Lazy initialization
     * + Fast performance
     * - Only for static fields
     */
    private static class Singleton1 {
        private static class SingletonHolder {
            private static final Singleton1 INSTANCE = new Singleton1();
        }

        private Singleton1() {
        }

        public static Singleton1 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * Double Checked Locking & volatile
     * <p>
     * + Lazy initialization
     * + Fast performance
     */
    private static class Singleton2 {
        private static volatile Singleton2 instance;

        public static Singleton2 getInstance() {
            Singleton2 localInstance = instance;
            if (instance == null) {
                synchronized (Singleton2.class) {
                    localInstance = instance;
                    if (instance == null) {
                        instance = localInstance = Singleton2.getInstance();
                    }
                }
            }
            return localInstance;
        }
    }

    /**
     * Enum singleton ;)
     */
    private enum Singleton3 {
        INSTANCE
    }

    public static void main(String[] args) {
        Object singleton0 = SingletonPatternDemo.INSTANCE;
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton3 singleton3 = Singleton3.INSTANCE;
    }
}
