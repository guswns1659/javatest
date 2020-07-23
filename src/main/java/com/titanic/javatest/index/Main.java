package com.titanic.javatest.index;

import com.titanic.javatest.LinkedList.LinkedList;
import com.titanic.javatest.LinkedList.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(new Node(null, 1));
        for (int i = 2; i < 11; i++) {
            linkedList.add(i);
        }

        Node node = linkedList.getHead();
        while (node != null) {
            System.out.println("node : " + node.getData());
            node = node.getNext();
        }
    }
}
