package ru.darvell.gb.interview.lesson1.poly;

public class Square implements Shape {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public String getName() {
        return "square";
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }
}
