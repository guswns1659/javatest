package com.titanic.javatest.tree;

import com.titanic.javatest.binarysearchtree.BinarySearchTree;
import com.titanic.javatest.binarysearchtree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;
    private HashSet<Integer> hashSet = new HashSet<>();

    @BeforeEach
    void 이진탐색트리를_생성한다() {
        TreeNode head = new TreeNode(500);
        this.binarySearchTree = new BinarySearchTree(head);

        while (this.hashSet.size() != 100) {
            int random = new Random().nextInt(999);
            this.hashSet.add(random);
            System.out.print(random + " , ");
        }

        for (Integer number : this.hashSet) {
            this.binarySearchTree.add(new TreeNode(number));
        }
    }

    @Test
    void 이진탐색트리의_add와_find를_테스트한다() {
        for (int number : this.hashSet) {
            assertThat(this.binarySearchTree.find(new TreeNode(number))).isTrue();
        }
    }

    @Test
    void 이진탐색트리의_delete를_테스트한다() {
        assertThat(this.binarySearchTree.delete(new TreeNode(3))).isTrue();
        assertThat(this.binarySearchTree.delete(new TreeNode(7))).isTrue();
    }

    @CsvSource({"500, 100"})
    @ParameterizedTest
    void 이진탐색트리의_size를_테스트한다(Integer number1, Integer size) {
        this.binarySearchTree.delete(new TreeNode(number1));
        assertThat(this.binarySearchTree.size()).isEqualTo(size);
    }
}
