package com.titanic.javatest.algorithm;

import java.util.List;

public class BinarySearch {
    public boolean search(List<Integer> list, int goal) {
        if (list.size() == 1 && goal == list.get(0)) {
            return true;
        }
        if (list.size() == 1 && goal != list.get(0)) {
            return false;
        }
        if (list.size() == 0) {
            return true;
        }

        int medium = list.size() / 2;
        if (goal == list.get(medium)) {
            return true;
        } else {
            if (goal > list.get(medium)) {
                return search(list.subList(medium, list.size()), goal);
            } else {
                return search(list.subList(0, medium), goal);
            }
        }
    }
}
