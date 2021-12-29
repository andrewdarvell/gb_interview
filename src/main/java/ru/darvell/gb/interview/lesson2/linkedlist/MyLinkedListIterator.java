package ru.darvell.gb.interview.lesson2.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedListIterator<E> implements Iterator<E> {

    private final Node<E> firstNode;
    private Node<E> cursor;

    public MyLinkedListIterator(Node<E> firstNode) {
        this.firstNode = firstNode;
    }

    public MyLinkedListIterator(Node<E> firstNode, int index) {
        this.firstNode = firstNode;
    }

    @Override
    public boolean hasNext() {
        return (cursor == null) ? firstNode != null : cursor.getNext() != null;
    }

    @Override
    public E next() {
        if (!hasNext()) throw new NoSuchElementException();
        cursor = (cursor == null) ? firstNode : cursor.getNext();
        return cursor.getValue();
    }

    Node<E> getCursorNode() {
        return cursor;
    }
}
