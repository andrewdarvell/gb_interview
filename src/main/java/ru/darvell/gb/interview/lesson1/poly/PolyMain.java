package ru.darvell.gb.interview.lesson1.poly;

import java.util.LinkedList;
import java.util.List;

public class PolyMain {

    public static void main(String[] args) {
        List<Shape> shapes = new LinkedList<>();
        shapes.add(new Triangle(3,4,5));
        shapes.add(new Square(23));
        shapes.add(new Triangle(4,3,4));
        shapes.add(new Circle(12));
        shapes.add(new Circle(23));

        shapes.forEach(PolyMain::printShape);
    }

    public static void printShape(Shape shape) {
        System.out.printf("I am %s with area: %.2f %n", shape.getName(), shape.getArea());
    }
}
