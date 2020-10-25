package com.titanic.javatest.dataStructure.hashtable;

public class Node {

    public String key;
    public String value;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void changeValue(String value) {
        this.value = value;
    }
}
