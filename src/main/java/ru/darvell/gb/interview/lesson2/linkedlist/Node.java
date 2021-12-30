package ru.darvell.gb.interview.lesson2.linkedlist;

import java.util.Objects;

class Node<E> {
    private Node<E> prev;
    private Node<E> next;
    private E value;

    public Node(E value) {
        this.value = value;
    }

    public Node(Node<E> prev, Node<E> next, E value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(prev, node.prev) && Objects.equals(next, node.next) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prev, next, value);
    }
}
