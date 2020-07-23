package com.titanic.javatest.LinkedList;

public class Node {

    private Node prev;
    private Integer data;
    private Node next;

    public Node(int data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
