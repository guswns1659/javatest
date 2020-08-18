package com.titanic.javatest.algorithm;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.swap;

public class BubbleSort {

    public void sort(List<Integer> unsortedList) {

        int unsortedListSize = unsortedList.size();

        for (int turn = 0; turn < unsortedListSize - 1; turn++) {
            boolean swap = false;
            for (int index = 0; index < unsortedListSize - turn - 1; index++) {
                if (unsortedList.get(index) > unsortedList.get(index+1)) {
                    Collections.swap(unsortedList, index, index+1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }

    }
}
