package ru.darvell.gb.interview.lesson2;

import ru.darvell.gb.interview.lesson2.arraylist.MyArrayList;

public class MainArray {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        System.out.println(list.get(1));
        System.out.println("=====================================");

        printArray(list);

        list.add("TT");
        printArray(list);

        list.insert("BB", 0);
        list.insert("DD", 3);

        printArray(list);

        list.remove(0);
        list.remove(3);
        list.remove(4);
        printArray(list);

        System.out.println(list.size());

    }

    public static <T> void printArray(MyArrayList<T> list) {
        for (T el: list) {
            System.out.println(el);
        }
        System.out.println("=====================================");
    }
}
