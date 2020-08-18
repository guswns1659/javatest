package com.titanic.javatest.algorithm;

import java.util.Collections;
import java.util.List;

public class InsertionSort {

    public void sort(List<Integer> unsortedList) {
        int unsortedListSize = unsortedList.size();

        for (int turn = 0; turn < unsortedListSize - 1; turn++) {
            for (int compare = turn + 1; compare > 0; compare--) {
                if (unsortedList.get(compare - 1) > unsortedList.get(compare)) {
                    Collections.swap(unsortedList, compare - 1, compare);
                } else {
                    break;
                }
            }
        }
    }
}
