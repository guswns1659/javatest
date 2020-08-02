package com.titanic.javatest.algorithm;

import java.util.List;

public class BubbleSort {


    public void sort(List<Integer> unsortedList) {

        int listSize = unsortedList.size();

        for (int turn = 0; turn < listSize - 1; turn++) {
            boolean swap = false;
            for (int i = 0; i < listSize - turn - 1; i++) {
                if (unsortedList.get(i) > unsortedList.get(i+1)) {
                    swap(unsortedList, i, i+1);
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }
    }

    private void swap(List<Integer> unsortedList, int index1, int index2) {
        int value1 = unsortedList.get(index1);
        int value2 = unsortedList.get(index2);
        unsortedList.remove(index1);
        unsortedList.add(index1, value2);
        unsortedList.remove(index2);
        unsortedList.add(index2, value1);
    }
}
