package com.arsatapathy.graph;

import java.util.*;

public class DFS {
    public static void search(Map<Integer, List<Integer>> graph, Integer start) {
        Set<Integer> visited = new HashSet<>();

        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while(!stack.isEmpty()) {
            Integer current = stack.pop();
            System.out.print(current + " ");
            visited.add(current);
            for(Integer neighbour :graph.get(current)) {
                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }
        }
    }

    public static void main(String... args){

        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, List.of(1,2));
        graph.put(1, List.of(2));
        graph.put(2, List.of(0,3));
        graph.put(3, List.of(3));

        search(graph, 2);
    }
}