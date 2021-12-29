package ru.darvell.gb.interview.lesson2.arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayListIterator<E> implements Iterator<E> {

    private MyArrayList<E> list;
    private int cursor = -1;

    public MyArrayListIterator(MyArrayList<E> list) {
        this.list = list;
    }


    @Override
    public boolean hasNext() {
        return (cursor == -1) ? list.size() > 0 : cursor < list.size() - 1;
    }

    @Override
    public E next() {
        if (!hasNext()) throw new NoSuchElementException();
        cursor++;
        return list.get(cursor);
    }

}
