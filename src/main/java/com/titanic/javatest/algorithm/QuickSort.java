package com.titanic.javatest.algorithm;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static List<Integer> quickSort(List<Integer> unsorted) {

        if (unsorted.size() <= 1) {
            return unsorted;
        }

        int pivot = unsorted.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int index = 1; index < unsorted.size(); index++) {
            int data = unsorted.get(index);
            if (pivot > data) {
                left.add(data);
            } else {
                right.add(data);
            }
        }

        left = quickSort(left);
        left.add(pivot);
        right = quickSort(right);
        left.addAll(right);

        return left;
    }
}
