package com.titanic.javatest.dataStructure.linkedlist;

public class DoublyLinkedList {

    private LinkedListNode head;
    private LinkedListNode tail;
    private int size;

    public DoublyLinkedList () {
        this.head = new LinkedListNode(null);
        this.tail = new LinkedListNode(null);
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }

    public void traverse() {
        LinkedListNode node = this.head.getNext();
        while (node.isTail()) {
            System.out.println("node : " + node.getValue());
            node = node.getNext();
        }
        System.out.println();
    }

    public boolean add(LinkedListNode newNode) {
        LinkedListNode current = this.tail;
        arrangeLink(newNode, current);
        this.size++;
        return true;
    }

    private void arrangeLink(LinkedListNode newNode, LinkedListNode current) {
        newNode.setPrev(current.getPrev());
        newNode.setNext(current);
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
    }

    public boolean add(int index, LinkedListNode newNode) {
        isOutOfIndex(index);
        LinkedListNode current = this.head.getNext();
        int startIndex = 0;
        while (startIndex != index) {
            current = current.getNext();
            startIndex++;
        }
        arrangeLink(newNode, current);
        this.size++;
        return true;
    }

    private void isOutOfIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return this.size;
    }

    public LinkedListNode get(Integer index) {
        isOutOfIndex(index);
        LinkedListNode current = this.head.getNext();
        int startIndex = 0;

        while (startIndex != index) {
            current = current.getNext();
            startIndex++;
        }
        return current;
    }

    public LinkedListNode remove(Integer index) {
        isOutOfIndex(index);
        LinkedListNode current = this.head.getNext();
        int startIndex = 0;
        while (startIndex != index) {
            current = current.getNext();
            startIndex++;
        }

        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());

        return current;
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
