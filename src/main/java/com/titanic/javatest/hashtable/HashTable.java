package com.titanic.javatest.hashtable;

import com.titanic.javatest.linkedlist.DoublyLinkedList;
import com.titanic.javatest.linkedlist.Node;

import java.util.Arrays;

public class HashTable {

    private DoublyLinkedList[] bucket;

    public HashTable() {
        this.bucket = new DoublyLinkedList[10];

        for (int i = 0; i < 10; i++) {
            this.bucket[i] = new DoublyLinkedList();
        }
    }

    public String put(String data, String value) {
        int key = getKey(data);
        int hashAddress = getHashAddress(key);

        Node newNode = new Node(data, value);
        this.bucket[hashAddress].add(newNode);
        return value;
    }

    public void traverse() {
        Arrays.stream(bucket).forEach(System.out::println);
    }

    private int getHashAddress(int key) {
        return key % this.bucket.length;
    }

    private int getKey(String data) {
        char[] charArray = data.toCharArray();
        int key = 0;
        for (char character : charArray) {
            key += character;
        }
        return key;
    }

    public DoublyLinkedList[] getBucket() {
        return bucket;
    }

    public void setBucket(DoublyLinkedList[] bucket) {
        this.bucket = bucket;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "bucket=" + Arrays.toString(bucket) +
                '}';
    }
}
