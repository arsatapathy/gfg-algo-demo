package com.arsatapathy;

import java.util.*;

public class BFS {

    public static void search(Map<Integer, List<Integer>> graph, int start) {
        Stack<Integer> visited = new Stack<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while(!queue.isEmpty()) {
            Integer current = queue.remove();
            System.out.println(current);
            visited.add(current);
            for(Integer neighbour :graph.get(current)) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String... args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, List.of(1,2));
        graph.put(1, List.of(2));
        graph.put(2, List.of(0,3));
        graph.put(3, List.of(3));

        search(graph, 2);
    }
}
