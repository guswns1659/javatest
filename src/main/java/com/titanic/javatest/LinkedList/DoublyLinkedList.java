package com.titanic.javatest.LinkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList () {
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }

    public void traverse() {
        Node node = this.head.getNext();
        while (node.getData() != -1) {
            System.out.println("node : " + node.getData());
            node = node.getNext();
        }
        System.out.println();
    }

    public int add(int data) {
        Node current = this.tail;
        Node newNode = new Node(data);

        newNode.setPrev(current.getPrev());
        newNode.setNext(current);
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);

        return newNode.getData();
    }

    public int addBefore(int data, int beforeData) {
        Node node = this.tail.getPrev();

        while (node.getData() != -1) {
            if (node.getData() == beforeData) {
                Node newNode = new Node(data);

                newNode.setPrev(node.getPrev());
                newNode.setNext(node);
                node.getPrev().setNext(newNode);
                node.setPrev(newNode);

                return newNode.getData();
            } else {
                node = node.getPrev();
            }
        }

        return -1;
    }
}
