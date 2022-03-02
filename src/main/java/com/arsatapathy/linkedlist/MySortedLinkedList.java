package com.arsatapathy.linkedlist;

public class MySortedLinkedList {

    static class Node {
        private int data;
        private Node next;

        Node() {
            data = 0;
            next = null;
        }

        Node(int data) {
            this.data = data;
            next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ",next=" + next +
                    "}";
        }
    }

    private Node head;
    private int length;

    public int getLength() {
        return length;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else if (head.data > data) {
            newNode.next = head;
            head = newNode;
        } else {

            Node current = head;

            while (current.next != null) {

                if (current.next.data > data) {
                    break;
                }

                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

    }

    public Node remove(int data) {
        Node current = head;

        if (current == null) {
            return null;
        }


        if (current.data == data) {
            head = head.next;
        } else {
            while (current.next != null) {
                if (current.next.data == data) {
                    current.next = current.next.next;
                    break;
                }

                current = current.next;
            }

        }

        return head;
    }

    public void traverse() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String... args) {
        MySortedLinkedList list = new MySortedLinkedList();

        list.addNode(5);
        list.addNode(1);
        list.addNode(4);
        list.addNode(2);
        list.addNode(3);

        list.traverse();

        System.out.println();

        list.remove(3);
        list.traverse();
    }

}
