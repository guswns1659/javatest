package com.titanic.javatest.algorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public List<Integer> mergeSplit(List<Integer> unsorted) {

        if (unsorted.size() <= 1) {
            return unsorted;
        }

        int medium = unsorted.size() / 2;
        List<Integer> left = mergeSplit(unsorted.subList(0, medium));
        List<Integer> right = mergeSplit(unsorted.subList(medium, unsorted.size()));

        return merge(left, right);
    }

    public List<Integer> merge(List<Integer> left, List<Integer> right) {

        List<Integer> sorted = new ArrayList<>(left.size() + right.size());
        int leftIndex = 0;
        int rightIndex = 0;

        // 1. 왼쪽, 오른쪽 리스트 둘 다 남았을 때
        while (left.size() > leftIndex && right.size() > rightIndex) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                sorted.add(left.get(leftIndex++));
            } else {
                sorted.add(right.get(rightIndex++));
            }
        }

        // 2. 왼쪽 리스트만 남았을 때
        while (left.size() > leftIndex) {
            sorted.add(left.get(leftIndex++));
        }

        // 3. 오른쪽 리스트만 남았을 때
        while (right.size() > rightIndex) {
            sorted.add(right.get(rightIndex++));
        }

        return sorted;
    }
}
