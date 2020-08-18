package com.titanic.javatest.algorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public List<Integer> sort(List<Integer> unsortedList) {

        if (unsortedList.size() <= 1) {
            return unsortedList;
        }
        int medium = unsortedList.size() / 2;
        List<Integer> left = sort(unsortedList.subList(0, medium));
        List<Integer> right = sort(unsortedList.subList(medium, unsortedList.size()));

        return merge(left, right);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> sortedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        // 1 : left, right 모두 남아 있을 때
        while (left.size() > leftIndex && right.size() > rightIndex) {
            if (left.get(leftIndex) > right.get(rightIndex)) {
                sortedList.add(right.get(rightIndex++));
            } else {
                sortedList.add(left.get(leftIndex++));
            }
        }

        // 2 : left만 남아 있을 때
        while (left.size() > leftIndex) {
            sortedList.add(left.get(leftIndex++));
        }

        // 3 : right만 남아 있을 때
        while (right.size() > rightIndex) {
            sortedList.add(right.get(rightIndex++));
        }
        return sortedList;
    }
}
