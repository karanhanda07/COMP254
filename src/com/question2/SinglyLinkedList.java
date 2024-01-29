package com.question2;

class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
        this.element = element;
    }
}

public class SinglyLinkedList<E> {
    private Node<E> head;

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Node<E> getNode(E element) {
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return current;
            }
            current = current.next;
        }
        return null; // element not found
    }

    public void swapNodes(Node<E> node1, Node<E> node2) {
        if (node1 == node2) return;

        Node<E> prev1 = null, prev2 = null, current = head;
        while (current != null && (prev1 == null || prev2 == null)) {
            if (current.next == node1) prev1 = current;
            if (current.next == node2) prev2 = current;
            current = current.next;
        }

        if (prev1 == null || prev2 == null) return; // One or both nodes not found

        // If one of the nodes to be swapped is the head of the list
        if (head == node1) head = node2;
        else if (head == node2) head = node1;

        // Swapping
        prev1.next = node2;
        prev2.next = node1;
        Node<E> temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;
    }

    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        Node<Integer> node1 = list.getNode(2);
        Node<Integer> node2 = list.getNode(3);

        if (node1 != null && node2 != null) {
            list.swapNodes(node1, node2);
        } else {
            System.out.println("One or both nodes not found.");
        }

        list.printList(); // Should print: 1 3 2 4 after the swap
    }
}