package ru.darvell.gb.interview.lesson2.arraylist;

import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {

    private Object[] arr;

    public void add(E value) {
        if (arr == null) {
            arr = new Object[1];
            arr[0] = value;
        } else {
            increaseAndCopyArray();
            arr[arr.length - 1] = value;
        }
    }

    public void insert(E value, int pos) {
        if (pos >= 0 && pos < arr.length) {
            moveAndCopyArray(pos);
            arr[pos] = value;
        } else {
            throw new IndexOutOfBoundsException("Cannot insert element.");
        }
    }

    private void increaseAndCopyArray() {
        Object[] newArr = new Object[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    private void moveAndCopyArray(int destPos) {
        Object[] newArr = new Object[arr.length + 1];
        int newI = 0;
        for (int i = 0; i < arr.length; i++) {
            if (destPos == newI) {
                newI += 1;
            }
            newArr[newI] = arr[i];
            newI++;
        }

        arr = newArr;
    }

    public E get(int pos) {
        return (E) arr[pos];
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator<>(this);
    }

    public int size() {
        return (arr == null) ? 0 : arr.length;
    }

    public void remove(int pos) {
        Object[] newArr = new Object[arr.length - 1];

        int oldI = -1;

        for (int newI = 0; newI < newArr.length; newI++) {
            oldI++;
            if (oldI == pos) oldI++;
            newArr[newI] = arr[oldI];
        }
        arr = newArr;
    }
}
