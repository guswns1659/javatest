package com.titanic.javatest.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dfs {

    public static void main(String[] args) {
        System.out.println("hello");
    }

    public List<String> search(Map<String, List<String>> graph, String startNode) {

        List<String> visited = new ArrayList<>(graph.size());
        List<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() != 0) {
            String popNode = needVisit.remove(needVisit.size() - 1);
            if (!visited.contains(popNode)) {
                visited.add(popNode);
                needVisit.addAll(graph.get(popNode));
            }
        }
        return visited;
    }
}
