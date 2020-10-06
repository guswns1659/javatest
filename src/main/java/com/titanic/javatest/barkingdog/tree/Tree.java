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

        bfs(1);
        parent = new int[6];
        depth = new int[6];
        dfs(1);
        parent = new int[6];
        depth = new int[6];
        recursiveDfs(1,0);
        System.out.println(Arrays.toString(depth));
    }

    /**
     * dfs만 재귀를 하는 이유는 다음 탐색을 자식노드로 하기 때문에 재귀 구조가 가능하다.
     */
    private static void recursiveDfs(int node) {
        System.out.println(node);
        for (int next : tree.get(node)) {
            if (parent[node] == next) continue;
            parent[next] = node;
            depth[next] = depth[node] + 1;
            recursiveDfs(next);
        }
    }

    private static void recursiveDfs(int current, int parent) {
        System.out.println(current);
        for (int next : tree.get(current)) {
            if (parent == next) continue;
            recursiveDfs(next, current);
        }
    }

    private static void dfs(int root) {
        Stack<Integer> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (int next : tree.get(current)) {
                if (parent[current] == next) continue;
                parent[next] = current;
                stack.push(next);
                depth[next] = depth[current] + 1;
            }
        }
    }

    private static void bfs(int root) {
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
}
