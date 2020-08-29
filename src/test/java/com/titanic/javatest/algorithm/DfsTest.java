package com.titanic.javatest.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DfsTest {

    private Dfs dfs;
    private Map<String, List<String>> graph;

    @BeforeEach
    void setUp() {
        this.dfs = new Dfs();
        this.graph = new LinkedHashMap<>();
        this.graph.put("A", Arrays.asList("B", "C"));
        this.graph.put("B", Arrays.asList("A", "D"));
        this.graph.put("C", Arrays.asList("A", "G", "H"));
        this.graph.put("D", Arrays.asList("B"));
        this.graph.put("G", Arrays.asList("C"));
        this.graph.put("H", Arrays.asList("C"));
    }

    @Test
    void Dfs알고리즘을_테스트한다() {
        // A, C, H, G, B, D
        System.out.println(dfs.search(graph, "A"));
    }
}
