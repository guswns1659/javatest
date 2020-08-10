package com.titanic.javatest.algorithm;

import java.util.List;

import static java.util.Collections.swap;

public class SelectionSort {

    public void sort(List<Integer> unsortedList) {

        int unsortedListSize = unsortedList.size();
        for (int stand = 0; stand < unsortedListSize - 1; stand++) {
            int lowest = stand;
            for (int compare = stand + 1; compare < unsortedListSize; compare++) {
                if (unsortedList.get(lowest) > unsortedList.get(compare)) {
                    lowest = compare;
                }
            }
            swap(unsortedList, stand, lowest);
        }
    }
}
