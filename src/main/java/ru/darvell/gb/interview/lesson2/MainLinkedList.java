package ru.darvell.gb.interview.lesson2;

import ru.darvell.gb.interview.lesson2.linkedlist.MyLinkedList;

import java.util.LinkedList;

public class MainLinkedList {

    public static void main(String[] args) {
        LinkedList listL = new LinkedList();


        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        for (String s: list) {
            System.out.println(s);
        }
        System.out.printf("size : %d%n", list.size());

        System.out.println("====================");

        list.add("T0", 0);
        list.add("T3", 3);
        list.add("T100", 100);
        list.add("T6", 6);

        for (String s: list) {
            System.out.println(s);
        }

        System.out.printf("size : %d%n", list.size());

        System.out.println("====================");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(7));

        System.out.println("====================");

        list.remove(3);
        list.remove(0);
        list.remove(4);
        list.remove(4);

        for (String s: list) {
            System.out.println(s);
        }

        System.out.printf("size : %d%n", list.size());


    }
}
