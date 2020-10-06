package com.titanic.javatest.barkingdog.tree;

import java.util.*;

public class Tree {

    private static int[] parent = new int[6];
    private static Map<Integer, List<Integer>> tree = new HashMap<>();
    private static int[] depth = new int[6];

    public static void main(String[] args) {
        // 트리
        // 1 = [2, 3], 2 = [1, 4, 5], 3 = [1], 4 = [2], 5 = [2]
        tree.put(1, Arrays.asList(2,3));
        tree.put(2, Arrays.asList(1,4,5));
        tree.put(3, Collections.singletonList(1));
        tree.put(4, Collections.singletonList(2));
        tree.put(5, Collections.singletonList(2));

        parentBfs(1);
        depthBfs(1);
        System.out.println(Arrays.toString(depth));
    }

    private static void depthBfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : tree.get(current)) {
                if (parent[current] == next) continue;
                parent[next] = current;
                queue.offer(next);
                depth[next] = depth[current] + 1;
            }
        }
    }

    public static void parentBfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 연결된 노드를 순회하고 자식 노드면 queue에 넣는다.
            for (int next : tree.get(current)) {
                // 부모 노드일 경우
                if (parent[current] == next) continue;
                queue.offer(next);
                parent[next] = current;
            }
        }
    }
}
