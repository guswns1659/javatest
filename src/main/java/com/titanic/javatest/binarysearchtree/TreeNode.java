package com.titanic.javatest.binarysearchtree;

public class TreeNode {

    private TreeNode left;
    private Integer value;
    private TreeNode right;

    public TreeNode(Integer value) {
        this(null, value, null);
    }

    public TreeNode(TreeNode left, Integer value, TreeNode right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
