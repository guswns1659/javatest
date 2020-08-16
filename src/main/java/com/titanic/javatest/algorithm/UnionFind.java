package com.titanic.javatest.algorithm;

import java.util.HashMap;

public class UnionFind {

    private static HashMap<Integer, Integer> parent = new HashMap<>();

    public static HashMap<Integer, Integer> test(int number) {
        for (int index = 1; index <= number; index++) {
            parent.put(index, index);
        }

        union(1,4);
        union(3,4);

        for (int index = 1; index <= number; index++) {
            find(index);
        }

        return parent;
    }

    private static void union(int x, int y) {
        int x2 = find(x);
        int y2 = find(y);

        if (x2 != y2) {
            parent.put(y2, x2);
        }
    }

    private static int find(int x) {
        if (x == parent.get(x)) {
            return x;
        }
        parent.put(x, find(parent.get(x)));
        return parent.get(x);
    }
}
