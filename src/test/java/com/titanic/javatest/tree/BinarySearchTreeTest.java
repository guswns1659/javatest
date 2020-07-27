package com.titanic.javatest.tree;

import com.titanic.javatest.binarysearchtree.BinarySearchTree;
import com.titanic.javatest.binarysearchtree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @BeforeEach
    void 이진탐색트리를_생성한다() {
        TreeNode head = new TreeNode(5);
        this.binarySearchTree = new BinarySearchTree(head);
    }

    @Test
    void 이진탐색트리의_insert와_find를_테스트한다() {

        for (int i = 1; i < 10; i+=2) {
            TreeNode treeNode = new TreeNode(i);
            assertThat(this.binarySearchTree.add(treeNode)).isEqualTo(i);
        }

        assertThat(this.binarySearchTree.find(new TreeNode(9))).isTrue();
        assertThat(this.binarySearchTree.find(new TreeNode(11))).isFalse();
    }
}
