package com.titanic.javatest.algorithm;

public class DynamicProgramming {

    public static int test(int number) {
        int[] memories = new int[number];
        memories[0] = 0;
        memories[1] = 1;

        for (int index = 2; index < memories.length; index++) {
            memories[index] = memories[index - 1] + memories[index - 2];
        }
        return memories[number-1];
    }
}
