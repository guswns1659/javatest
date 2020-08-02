package com.titanic.javatest.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class BubbleSortTest {

    private BubbleSort bubbleSort;
    private List<Integer> unsortedList;

    @BeforeEach
    void 버블정렬을_생성한다() {
        this.bubbleSort = new BubbleSort();

        Set<Integer> randomSet = new HashSet<>(30);
        while(randomSet.size() != 30) {
            randomSet.add(new Random().nextInt(100));
        }
        this.unsortedList = new ArrayList<>(randomSet);
    }

    @Test
    void 버블정렬을_테스트한다() {

        System.out.println(unsortedList);
        this.bubbleSort.sort(unsortedList);
        System.out.println(unsortedList);
    }
}
