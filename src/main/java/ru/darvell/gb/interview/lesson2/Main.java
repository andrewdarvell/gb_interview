package ru.darvell.gb.interview.lesson2;

import ru.darvell.gb.interview.lesson2.linkedlist.MyLinkedList;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList listL = new LinkedList();


        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        for (String s: list) {
            System.out.println(s);
        }

        System.out.println(list);

    }
}
