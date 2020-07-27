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

    public boolean delete(TreeNode deletingNode) {

        // 삭제하려는 노드가 없는 경우
        boolean searched = false;
        TreeNode current = this.head;
        TreeNode parent = this.head;

        while (current != null) {
            if (deletingNode.getValue().equals(current.getValue())) {
                searched = true;
                break;
            } else if (deletingNode.getValue() < current.getValue()) {
                parent = current;
                current = current.getLeft();
            } else {
                parent = current;
                current = current.getRight();
            }
        }

        if (!searched) {
            return false;
        }

        // 1. 삭제하는 노드의 자식이 없는 경우
        if (current.getLeft() == null && current.getRight() == null) {
            if (deletingNode.getValue() < parent.getValue()) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            return true;
        }
        // 2. 삭제하는 노드의 자식이 1개인 경우
        // 2-1 삭제하는 노드의 자식이 왼쪽 노드인 경우
        if (current.getLeft() != null && current.getRight() == null) {
            if (deletingNode.getValue() < parent.getValue()) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
            return true;
        }
        // 2-2 삭제하는 노드의 자식이 오른쪽 노드인 경우
        if (current.getLeft() == null && current.getRight() != null) {
            if (deletingNode.getValue() < parent.getValue()) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
            return true;
        }

        // 3. 삭제하는 노드의 자식이 2개인 경우
        if (current.getLeft() != null && current.getRight() != null) {
            TreeNode changeNode = current.getRight();
            TreeNode changeParentNode = current.getRight();
            while (changeNode.getLeft() != null) {
                changeParentNode = changeNode;
                changeNode = changeNode.getLeft();
            }
            // 3-2-1 바뀌는 노드의 자식노드가 없는 경우
            if (changeNode.getRight() == null) {
                changeParentNode.setLeft(null);
            // 3-2-2 바뀌는 노드가 오른쪽 자식 노드가 있는 경우
            } else {
                changeParentNode.setLeft(changeNode.getRight());
            }
            // 3-1 삭제하는 노드가 부모 노드의 왼쪽에 있는 경우
            if (current.getValue() < parent.getValue()) {
                parent.setLeft(changeNode);
            // 3-2 삭제하는 노드가 부모 노드의 오른쪽에 있는 경우
            } else {
                parent.setRight(changeNode);
            }
            changeNode.setLeft(current.getLeft());
            // 3-3 바뀌는 노드와 삭제하려는 노드의 위치를 바꾸는데 바꾼 뒤에 자기 자신이 오른쪽에 안달려있기 위한 조건
            if (parent.getRight() != changeNode) {
                changeNode.setRight(current.getRight());
            }
            return true;
        }
        return false;
    }
}
