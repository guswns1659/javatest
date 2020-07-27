package com.titanic.javatest.binarysearchtree;

public class BinarySearchTree {

    private TreeNode head;

    public BinarySearchTree(TreeNode head) {
        this.head = head;
    }

    public int add(TreeNode newNode) {
        TreeNode current = this.head;

        while (true) {
            if (newNode.getValue() < current.getValue()) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(newNode);
                    return newNode.getValue();
                }
            } else {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(newNode);
                    return newNode.getValue();
                }
            }
        }
    }

    public boolean find(TreeNode findingNode) {
        TreeNode current = this.head;

        while (current != null) {
            if (findingNode.getValue().equals(current.getValue())) {
                return true;
            }
            if (findingNode.getValue() < current.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

        }
        return false;
    }
}
