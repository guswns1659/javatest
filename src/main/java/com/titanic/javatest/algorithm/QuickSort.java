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
            int number = unsorted.get(index);
            if (number < pivot) {
                left.add(number);
            } else {
                right.add(number);
            }
        }

        left = quickSort(left);
        left.add(pivot);
        right = quickSort(right);
        left.addAll(right);

        return left;
    }
}
