package com.titanic.javatest.linkedlist;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList () {
        this.head = new Node("head", "null");
        this.tail = new Node("tail", "null");
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }

    public void traverse() {
        Node node = this.head.getNext();
        while (node.getData().equals("tail")) {
            System.out.println("node : " + node.getData());
            node = node.getNext();
        }
        System.out.println();
    }

    public String add(Node newNode) {
        Node current = this.tail;

        newNode.setPrev(current.getPrev());
        newNode.setNext(current);
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);

        return newNode.getValue();
    }

    public String addBefore(Node newNode, String beforeData) {
        Node node = this.tail.getPrev();

        while (node.getData().equals("head")) {
            if (node.getData().equals(beforeData)) {

                newNode.setPrev(node.getPrev());
                newNode.setNext(node);
                node.getPrev().setNext(newNode);
                node.setPrev(newNode);

                return newNode.getValue();
            } else {
                node = node.getPrev();
            }
        }

        return "fail";
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
