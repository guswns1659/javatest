package com.titanic.javatest.LinkedList;

public class LinkedList {
    private Node head;

    public LinkedList (Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void add(int data) {
        Node node = this.head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(new Node(data));
    }

    public void traverse() {
        Node node = this.head;
        while (node != null) {
            System.out.println("node : " + node.getData());
            node = node.getNext();
        }
    }

    public Node getTail() {
        Node node = this.head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node;
    }

    public int delete(Integer data) {
        // head 삭제
        Node node = this.head;
        if (node.getData() == data) {
            this.head = node.getNext();
            return node.getData();
        }

        // 중간노드 삭제, tail 노드 삭제
        while (node.getNext() != null) {
            if (node.getNext().getData() == data) {
                Node removed = node.getNext();
                node.setNext(node.getNext().getNext());
                return removed.getData();
            } else {
                node = node.getNext();
            }
        }
        return -1;
    }

    public int find(Integer data) {
        Node node = this.head;

        while (node != null) {
            if (node.getData() == data) {
                return node.getData();
            } else {
                node = node.getNext();
            }
        }
        return -1;
    }
}
