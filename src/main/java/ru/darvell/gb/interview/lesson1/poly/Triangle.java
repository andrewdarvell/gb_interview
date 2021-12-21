package ru.darvell.gb.interview.lesson1.poly;

public class Triangle implements Shape{

    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public String getName() {
        return "triangle";
    }

    @Override
    public double getArea() {
        double p = halfArea();
        return Math.sqrt(p * (p-sideA)* (p-sideB) *(p-sideC));
    }

    private double halfArea() {
        return (sideA + sideB + sideC) / 2;
    }
}
