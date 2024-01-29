package com.question3;

public class CircularlyLinkedList<E> implements Cloneable {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {
        // Constructor
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, (tail == null) ? null : tail.next);
        if (tail == null)
            newest.next = newest; // creates a circular reference
        else
            tail.next = newest;
        tail = newest;
        size++;
    }

    @Override
    public CircularlyLinkedList<E> clone() {
        CircularlyLinkedList<E> other = new CircularlyLinkedList<>();
        if (tail != null) {
            Node<E> walk = tail.next; // Start from head
            do {
                other.addLast(walk.element);
                walk = walk.next;
            } while (walk != tail.next);
        }
        return other;
    }

    public void printList() {
        if (tail == null) return;
        Node<E> head = tail.next;
        Node<E> walk = head;
        do {
            System.out.print(walk.element + " ");
            walk = walk.next;
        } while (walk != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        CircularlyLinkedList<Integer> clonedList = list.clone();
        clonedList.printList(); // Should print: 1 2 3
    }
}
