package com.titanic.javatest.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MergeSortTest {

    private MergeSort mergeSort;
    private List<Integer> unsortedList;

    @BeforeEach
    void setUp() {
        this.mergeSort = new MergeSort();

        Set<Integer> randomSet = new HashSet<>();
        while (randomSet.size() != 30) {
            randomSet.add(new Random().nextInt(100));
        }
        this.unsortedList = new ArrayList<>(randomSet);
    }

    @Test
    void 병합정렬을_테스트한다() {
        System.out.println(this.unsortedList);
        System.out.println(this.mergeSort.mergeSplit(this.unsortedList));
    }
}
