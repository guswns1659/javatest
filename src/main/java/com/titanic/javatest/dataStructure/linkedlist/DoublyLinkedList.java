package com.titanic.javatest.dataStructure.linkedlist;

public class DoublyLinkedList {

    public LinkedListNode head;
    public LinkedListNode tail;
    public int size;

    public DoublyLinkedList() {
        head = new LinkedListNode(null);
        tail = new LinkedListNode(null);
        head.next = tail;
        tail.prev = head;
    }

    public void add(LinkedListNode newNode) {
        LinkedListNode current = tail;
        // 링크 조절
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    public LinkedListNode get(int findingIndex) {
        return findingNode(findingIndex);
    }

    public LinkedListNode remove(int findingIndex) {
        LinkedListNode current = findingNode(findingIndex);

        // 삭제할 노드의 링크 조정
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return current;
    }

    private LinkedListNode findingNode(int findingIndex) {
        LinkedListNode current = head.next;
        int index = 0;
        while (isFindingIndex(findingIndex, index)) {
            current = current.next;
            index++;
        }
        return current;
    }

    private boolean isFindingIndex(int findingIndex, int index) {
        return index != findingIndex;
    }
}
