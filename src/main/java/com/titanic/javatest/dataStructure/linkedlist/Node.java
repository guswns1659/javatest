package com.titanic.javatest.dataStructure.linkedlist;

public class Node {

    private Node prev;
    private String data;
    private String value;
    private Node next;

    public Node(String data, String value) {
        this.prev = null;
        this.data = data;
        this.value = value;
        this.next = null;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "prev=" + prev +
                ", data='" + data + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
