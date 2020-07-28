package com.titanic.javatest.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap = new ArrayList<>();

    public Heap() {
        this.heap.add(null);
    }

    public boolean add(int added) {
        this.heap.add(added);
        int addedIndex = this.heap.size() - 1;

        while (isMoveUp(addedIndex)) {
            int parentIndex = addedIndex / 2;
            swap(parentIndex, addedIndex);
            addedIndex = parentIndex;
        }
        return true;
    }

    private boolean isMoveUp(int addedIndex) {
        if (addedIndex == 1) {
            return false;
        }

        int parentIndex = addedIndex / 2;
        return this.heap.get(addedIndex) > this.heap.get(parentIndex);
    }

    private void swap(int parentIndex, int addedIndex) {
        int parentValue = this.heap.get(parentIndex);
        int addedValue = this.heap.get(addedIndex);
        this.heap.remove(parentIndex);
        this.heap.add(parentIndex, addedValue);
        this.heap.remove(addedIndex);
        this.heap.add(addedIndex, parentValue);
    }

    public void traverse() {
        this.heap.forEach(System.out::println);
    }
}
