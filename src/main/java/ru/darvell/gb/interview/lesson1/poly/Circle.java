package ru.darvell.gb.interview.lesson1.poly;

public class Circle implements Shape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
