package com.titanic.javatest.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class InsertionSortTest {

    private InsertionSort insertionSort;
    private List<Integer> unsortedList;

    @BeforeEach
    void 삽입정렬을_생성한다() {
        this.insertionSort = new InsertionSort();

        Set<Integer> randomSet = new HashSet<>(30);
        while(randomSet.size() != 30) {
            randomSet.add(new Random().nextInt(100));
        }
        this.unsortedList = new ArrayList<>(randomSet);
    }

    @Test
    void 삽입정렬을_테스트한다() {
        System.out.println(this.unsortedList);
        this.insertionSort.sort(this.unsortedList);
        System.out.println(this.unsortedList);
    }
}
