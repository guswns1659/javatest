package com.titanic.javatest.hashtable;

import java.util.Arrays;

public class HashTable {

    private String[] bucket;

    public HashTable() {
        this.bucket = new String[10];
    }

    public String put(String data, String value) {
        int key = getKey(data);
        int hashAddress = getHashAddress(key);
        return this.bucket[hashAddress] = value;
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
}
