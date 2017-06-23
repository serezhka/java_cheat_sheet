package com.github.serezhka.pattern;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

/**
 * In Strategy pattern, a class behavior or its algorithm can be changed at run time.
 * This type of design pattern comes under behavior pattern.
 * <p>
 * In Strategy pattern, we create objects which represent various strategies and a context object
 * whose behavior varies as per its strategy object.
 * The strategy object changes the executing algorithm of the context object.
 *
 * @author Sergei Fedorov (serezhka@xakep.ru)
 * @since 22.06.2017
 */
public class StrategyPatternDemo {

    private static class Context {

        private final byte $0 = 0;
        private final byte $1 = 1;

        private IntBinaryOperator strategy;

        public void setStrategy(IntBinaryOperator strategy) {
            this.strategy = strategy;
        }

        public int execute() {
            return strategy.applyAsInt($0, $1);
        }
    }

    public static void main(String[] args) {
        Context context = new Context();

        List<IntBinaryOperator> strategies =
                Arrays.asList(
                        (a, b) -> a * b,
                        (a, b) -> a + b
                );

        strategies.forEach(strategy -> {
            context.setStrategy(strategy);
            System.out.println(context.execute());
        });
    }
}

