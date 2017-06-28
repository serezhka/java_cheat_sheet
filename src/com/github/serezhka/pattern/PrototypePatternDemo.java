package com.github.serezhka.pattern;

/**
 * @author Sergei Fedorov (sergei.fedorov@t-systems.ru)
 * @since 23.06.2017
 */
public class PrototypePatternDemo {

    private interface Shape extends Cloneable {
        Shape copy();
    }

    private static class Circle implements Shape {

        public Circle() {
            System.out.println("In Circle constructor");
        }

        @Override
        public Shape copy() {
            System.out.println("Circle is being copied");
            try {
                return (Shape) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private static class ShapeCloner {
        public Shape makeCopy(Shape shape) {
            return shape.copy();
        }
    }

    public static void main(String[] args) {
        ShapeCloner shapeCloner = new ShapeCloner();
        Circle circle = new Circle();
        Circle clonedCircle = (Circle) shapeCloner.makeCopy(circle);
        System.out.println(circle + " != " + clonedCircle);
    }
}
