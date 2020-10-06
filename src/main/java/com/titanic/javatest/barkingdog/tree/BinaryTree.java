package com.titanic.javatest.barkingdog.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private static int[] lc = new int[]{0,2,4,6,0,0,0,0,0};
    private static int[] rc = new int[]{0,3,5,7,0,8,0,0,0};
    private static int[] parents = new int[9];

    public static void main(String[] args) {
        int root = 1;
        levelTraversal(root);
        System.out.println(Arrays.toString(parents));
//        preorderTraversal(root);
//        inorderTraversal(root);
//        postTraversal(root);
    }

    private static void postTraversal(int current) {
        if (lc[current] != 0) postTraversal(lc[current]);
        if (rc[current] != 0) postTraversal(rc[current]);
        System.out.println(current);
    }

    private static void inorderTraversal(int current) {
        if (lc[current] != 0) inorderTraversal(lc[current]);
        System.out.println(current);
        if (rc[current] != 0) inorderTraversal(rc[current]);
    }

    private static void preorderTraversal(int current) {
        System.out.println(current);
        if (lc[current] != 0) preorderTraversal(lc[current]);
        if (rc[current] != 0) preorderTraversal(rc[current]);
    }

    /** 레벨 순회
     *  bfs 방식으로 순회하면된다. 다만, lc, rc에 맞게 구현해야 한다
     */
    private static void levelTraversal(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println(current);
            if (lc[current] != 0) {
                parents[lc[current]] = current;
                queue.offer(lc[current]);
            }
            if (rc[current] != 0) {
                parents[rc[current]] = current;
                queue.offer(rc[current]);
            }
        }
    }
}
