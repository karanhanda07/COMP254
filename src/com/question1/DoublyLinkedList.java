package com.question1;
class Node<E> {
    E element;
    Node<E> prev;
    Node<E> next;

    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }
}

class DoublyLinkedList<E> {
    private Node<E> header;
    private Node<E> trailer;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, trailer.prev, trailer);
        trailer.prev.next = newNode;
        trailer.prev = newNode;
    }

    public void concatenate(DoublyLinkedList<E> other) {
        if (other != null && other.header.next != other.trailer) {
            this.trailer.prev.next = other.header.next;
            other.header.next.prev = this.trailer.prev;
            this.trailer = other.trailer;
        }
    }

    public void printList() {
        Node<E> current = header.next;
        while (current != trailer) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> L = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> M = new DoublyLinkedList<>();
        L.addLast(1);
        L.addLast(2);
        M.addLast(3);
        M.addLast(4);

        L.concatenate(M);
        L.printList(); // Should print: 1 2 3 4
    }
}
