package com.titanic.javatest.dataStructure.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap = new ArrayList<>();
    private final static int ONE = 1;
    private final static int TWO = 2;

    public Heap() {
        this.heap.add(null);
    }

    public boolean add(int added) {
        this.heap.add(added);
        int addedIndex = this.heap.size() - ONE;

        while (isMoveUp(addedIndex)) {
            int parentIndex = addedIndex / TWO;
            swap(parentIndex, addedIndex);
            addedIndex = parentIndex;
        }
        return true;
    }

    public void traverse() {
        this.heap.forEach(System.out::println);
    }

    public Integer pop() {
        if (this.heap.size() <= ONE) {
            return null;
        }
        int returnedData = this.heap.get(ONE);
        this.heap.remove(ONE);
        this.heap.add(ONE, this.heap.get(this.heap.size() - ONE));
        this.heap.remove(this.heap.size() - ONE);

        int poppedIndex = ONE;

        while (isMoveDown(poppedIndex)) {
            int leftChildIndex = poppedIndex * TWO;
            int rightChildIndex = poppedIndex * TWO + ONE;

            // 2. 오른쪽 자식 노드만 없을 때
            if (rightChildIndex >= this.heap.size()) {
                if (this.heap.get(poppedIndex) < this.heap.get(leftChildIndex)) {
                    swap(poppedIndex, leftChildIndex);
                    poppedIndex = leftChildIndex;
                }
            }
            // 3. 왼쪽, 오른쪽 자식 노드 모두 있을 때
            if (this.heap.get(leftChildIndex) >= this.heap.get(rightChildIndex)) {
                if (this.heap.get(poppedIndex) < this.heap.get(leftChildIndex)) {
                    swap(poppedIndex, leftChildIndex);
                    poppedIndex = leftChildIndex;
                }
            } else {
                if (this.heap.get(poppedIndex) < this.heap.get(rightChildIndex)) {
                    swap(poppedIndex, rightChildIndex);
                    poppedIndex = rightChildIndex;
                }
            }
        }
        return returnedData;
    }

    private boolean isMoveUp(int addedIndex) {
        if (addedIndex == ONE) {
            return false;
        }

        int parentIndex = addedIndex / TWO;
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

    private boolean isMoveDown(int poppedIndex) {
        int leftChildIndex = poppedIndex * TWO;
        int rightChildIndex = poppedIndex * TWO + ONE;

        // 1. 왼쪽 자식 노드도 없을 때 (완전이진트리라서 오른쪽 자식 노드만 있을 수가 없다.)
        if (leftChildIndex >= this.heap.size()) {
            return false;
        }
        // 2. 오른쪽 자식 노드만 없을 때
        if (rightChildIndex >= this.heap.size()) {
            return this.heap.get(poppedIndex) < this.heap.get(leftChildIndex);
        }
        // 3. 왼쪽, 오른쪽 자식 노드 모두 있을 때
        int maxData = Math.max(this.heap.get(leftChildIndex), this.heap.get(rightChildIndex));
        return this.heap.get(poppedIndex) < maxData;
    }

    public List<Integer> getHeap() {
        return heap;
    }
}
