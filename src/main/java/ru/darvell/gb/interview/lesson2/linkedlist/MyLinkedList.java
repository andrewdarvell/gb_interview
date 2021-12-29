package ru.darvell.gb.interview.lesson2.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {


    private Node<E> firstNode;
    private Node<E> lastNode;

    private int size;

    public int size() {
        return size;
    }

    public boolean add(E element) {
        Node<E> node = new Node<>(element);
        if (lastNode == null) {
            firstNode = node;
            lastNode = node;
            size++;
        } else {
            setNewLast(node);
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator<>(getFirstNode());
    }

    Node<E> getFirstNode() {
        return firstNode;
    }

    Node<E> getLastNode() {
        return lastNode;
    }

    public boolean add(E element, int pos) {
        if (pos < 0) return false;
        if (pos == 0) {
            setNewFirst(new Node<>(element));
            return true;
        }
        if (pos >= size) {
            setNewLast(new Node<>(element));
            return true;
        }
        insertBefore(((MyLinkedListIterator<E>) iterator(pos)).getCursorNode(), new Node<>(element));
        return true;
    }

    private void insertBefore(Node<E> current, Node<E> newNode) {
        Node<E> prevNode = current.getPrev();
        if (prevNode != null) {
            prevNode.setNext(newNode);
            newNode.setPrev(prevNode);
        }
        newNode.setNext(current);
        current.setPrev(newNode);
        size++;
    }

    private void setNewFirst(Node<E> node) {
        if (firstNode != null) {
            firstNode.setPrev(node);
            node.setNext(firstNode);
        } else {
            lastNode = node;
        }
        firstNode = node;
        size++;
    }

    private void setNewLast(Node<E> node) {
        if (lastNode != null) {
            lastNode.setNext(node);
            node.setPrev(lastNode);
        } else {
            firstNode = node;
        }
        lastNode = node;
        size++;
    }

    private Iterator<E> iterator(int index) throws NoSuchElementException {
        Iterator<E> iterator = iterator();
        int i = 0;
        do {
            i++;
            iterator.next();
        } while (i <= index);
        return iterator;
    }

    public E get(int index) {
        try {
            return ((MyLinkedListIterator<E>) iterator(index)).getCursorNode().getValue();
        } catch (NoSuchElementException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    public boolean remove(int pos) {
        if (pos == 0) {
            return removeFirst();
        }
        if (pos == size - 1) {
            return removeLast();
        }
        return removeElement(((MyLinkedListIterator<E>) iterator(pos)).getCursorNode());
    }

    private boolean removeFirst() {
        if (size == 1) {
            removeOneLastElement();
            return true;
        }
        if (size > 1) {
            firstNode = firstNode.getNext();
            firstNode.setPrev(null);
            size --;
            return true;
        }
        return false;
    }

    private boolean removeLast() {
        if (size == 1) {
            removeOneLastElement();
            return true;
        }
        if (size > 1) {
            lastNode = lastNode.getPrev();
            lastNode.setNext(null);
            size --;
            return true;
        }
        return false;
    }

    private void removeOneLastElement(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    private boolean removeElement(Node<E> node){
        Node<E> prev = node.getPrev();
        Node<E> next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return true;
    }

}
