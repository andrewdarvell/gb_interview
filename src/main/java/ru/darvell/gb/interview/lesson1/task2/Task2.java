package ru.darvell.gb.interview.lesson1.task2;

/**
 * В классе Car поле engine следует сделать приватным (сеттер и геттер на это поле уже есть)
 * Неясно зачем в классе Car метод start() объявлен как protected. В данной ситауции я бы сделал public
 * Класс Lorry пытается унаследоваться от другого класса и интерфейса. Нельзя классам наследовать интерфейсы
 * В Lorry не указано @Override над переопределёнными методами
 * Lorry наследуется от Car, но не переопределяет абстрактный метод open(). Надо либо переопределить, либо сделать класс
 * Lorry абстрактным
 * Я бы сделал все эти классы и интрерфейсы как public. Не похоже, что LightWeightCar и Lorry будут ограничены
 * одним пакетом (но это не точно)
 *
 * Я убрал абстрактность у метода open() в классе Car. Не вижу смысла его переопределять в каждом наследнике.
 * Поправил модификаторы доступа, исправил объявление наследования в Lorry.
 *
 */

//public class Task2 {
//    interface Moveable {
//        void move();
//    }
//
//    interface Stopable {
//        void stop();
//    }
//
//    abstract class Car {
//        public Engine engine;
//        private String color;
//        private String name;
//
//
//        protected void start() {
//            System.out.println("Car starting");
//        }
//
//        abstract void open();
//
//        public Engine getEngine() {
//            return engine;
//        }
//
//        public void setEngine(Engine engine) {
//            this.engine = engine;
//        }
//
//        public String getColor() {
//            return color;
//        }
//
//        public void setColor(String color) {
//            this.color = color;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//
//    class LightWeightCar extends Car implements Moveable {
//
//        @Override
//        void open() {
//            System.out.println("Car is open");
//        }
//
//        @Override
//        public void move() {
//            System.out.println("Car is moving");
//        }
//
//    }
//
//    class Lorry extends Car, Moveable, Stopable {
//
//        public void move() {
//            System.out.println("Car is moving");
//        }
//
//        public void stop() {
//            System.out.println("Car is stop");
//        }
//    }
//
//}
