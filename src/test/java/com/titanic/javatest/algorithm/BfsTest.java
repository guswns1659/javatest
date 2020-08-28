package com.titanic.javatest.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class BfsTest {

    private Bfs bfs;
    private Map<String, List<String>> graph;

    @BeforeEach
    void setUp() {
        this.bfs = new Bfs();
        this.graph = new LinkedHashMap<>();
        this.graph.put("A", Arrays.asList("B", "C"));
        this.graph.put("B", Arrays.asList("A", "D"));
        this.graph.put("C", Arrays.asList("A", "G", "H"));
        this.graph.put("D", Arrays.asList("B"));
        this.graph.put("G", Arrays.asList("C"));
        this.graph.put("H", Arrays.asList("C"));
    }

    @Test
    void Bfs알고리즘을_테스트한다() {
        // A, B, C, D, G, H
        System.out.println(bfs.search(graph, "A"));
    }
}
