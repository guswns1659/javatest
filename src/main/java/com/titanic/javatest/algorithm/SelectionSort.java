package com.titanic.javatest.algorithm;

import java.util.List;

public class SelectionSort {

    public void sort(List<Integer> unsortedList) {

        for (int stand = 0; stand < unsortedList.size() - 1; stand++) {
            int lowest = stand;
            for (int compare = stand + 1; compare < unsortedList.size(); compare++) {
                if (unsortedList.get(lowest) > unsortedList.get(compare)) {
                    lowest = compare;
                }
            }
            swap(unsortedList, stand, lowest);
        }
    }

    private void swap(List<Integer> unsortedList, int stand, int lowest) {
        int standValue = unsortedList.get(stand);
        int lowestValue = unsortedList.get(lowest);
        unsortedList.remove(stand);
        unsortedList.add(stand, lowestValue);
        unsortedList.remove(lowest);
        unsortedList.add(lowest, standValue);
    }
}
