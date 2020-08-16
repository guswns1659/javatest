package com.titanic.javatest.algorithm;

public class Counting {
    public static void sort(int[] numbers) {

        int[] data = new int[10001];

        for (int number : numbers) {
            data[number]++;
        }

        for (int index = 0; index < 10001; index++) {
            if (data[index] != 0) {
                for (int loop = 0; loop < data[index]; loop++) {
                    System.out.print(index + " ");
                }
            }
        }
    }
}
