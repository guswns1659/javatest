package com.titanic.javatest.algorithm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SelectionSortTest {

    private SelectionSort selectionSort;
    private List<Integer> unsortedList;
    private long startTime;
    private long endTime;

    @BeforeEach
    void 선택정렬을_생성한다() {
        this.selectionSort = new SelectionSort();

        Set<Integer> randomSet = new HashSet<>(30);
        while (randomSet.size() != 30) {
            randomSet.add(new Random().nextInt(100));
        }
        this.unsortedList = new ArrayList<>(randomSet);
        this.startTime = System.nanoTime();
    }

    @Test
    void 선택정렬을_테스트한다() {
        System.out.println(this.unsortedList);
        this.selectionSort.sort(this.unsortedList);
        System.out.println(this.unsortedList);
    }

    @AfterEach
    void tearDown() {
        this.endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1000000.0;
        System.out.println("elapsedTime : " + elapsedTime);
    }
}
