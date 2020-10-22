package com.titanic.javatest.dataStructure.linkedlist;

public class LinkedListNode {

    private LinkedListNode prev;
    private Integer value;
    private LinkedListNode next;

    public LinkedListNode(Integer value) {
        this.value = value;
    }

    public LinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(LinkedListNode prev) {
        this.prev = prev;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public boolean isNotTail() {
        return this.value != null;
    }
}
