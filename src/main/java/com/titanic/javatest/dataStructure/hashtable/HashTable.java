package com.titanic.javatest.dataStructure.hashtable;

import java.util.LinkedList;

public class HashTable {

    public LinkedList<Node>[] bucket;
    public int size;

    public HashTable(int size) {
        bucket = new LinkedList[size];
    }

    public void put(String key, String value) {
        int hash = getHash(key);
        LinkedList<Node> list = bucket[hash];

        // 해당 key의 데이터가 있는지 확인하는 작업 추가
        Node node = searchNode(list, key);
        if (node == null) {
            if (list == null) {
                list = new LinkedList<>();
                bucket[hash] = list;
            }

            list.addLast(new Node(key, value));
            size++;
        } else {
            node.changeValue(value);
        }
    }

    public String get(String key) {
        int hash = getHash(key);
        LinkedList<Node> list = bucket[hash];
        Node node = searchNode(list, key);
        return (node != null) ? node.value : null;
    }

    private Node searchNode(LinkedList<Node> list, String key) {
        // 해당 리스트가 없다면
        if (list == null) {
            return null;
        }

        // key가 없다면 null을 리턴한다
        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    private int getHash(String key) {
        // 모든 문자열을 더한 뒤 버킷사이즈로 나눈다
        char characterSum = ' ';
        for (char character : key.toCharArray()) {
            characterSum += character;
        }
        return characterSum % bucket.length;
    }

}
