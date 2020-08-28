package com.titanic.javatest.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bfs {

    public List<String> search(Map<String, List<String>> graph, String startNode) {
        List<String> needVisit = new ArrayList<>();
        List<String> visited = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() != 0) {

            String needVisitNode = needVisit.remove(0);
            if (!visited.contains(needVisitNode)) {
                visited.add(needVisitNode);
                needVisit.addAll(graph.get(needVisitNode));
            }
        }
        return visited;
    }
}
