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
            if (pivot > unsorted.get(index)) {
                left.add(unsorted.get(index));
            } else {
                right.add(unsorted.get(index));
            }
        }
        left = quickSort(left);
        left.add(pivot);
        right = quickSort(right);
        left.addAll(right);
        return left;
    }
}
