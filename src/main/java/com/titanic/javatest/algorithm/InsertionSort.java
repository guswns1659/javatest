package com.titanic.javatest.algorithm;

import java.util.List;

public class InsertionSort {

    public void sort(List<Integer> unsortedList) {

        for (int turn = 0; turn < unsortedList.size() - 1; turn++) {
            // 이부분이 헷갈리니 나중에 볼 때 그림 그리면서 차근차근 해보기
            for (int compare = turn + 1; compare > 0; compare--) {
                if (unsortedList.get(compare - 1) > unsortedList.get(compare)) {
                    swap(unsortedList, compare -1, compare);
                } else {
                    break;
                }
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
