package com.arsatapathy;

import java.util.*;

public class BFS {

    public static void search(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while(!queue.isEmpty()) {
            Integer current = queue.remove();
            System.out.print(current + " ");
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

        System.out.println();

        System.out.println(shortestDistance(graph, 0, 3));
        System.out.println(shortestDistance(graph, 0, 1));
        System.out.println(shortestDistance(graph, 1, 0));
        System.out.println(shortestDistance(graph, 1, 2));
        System.out.println(shortestDistance(graph, 2, 0));
        System.out.println(shortestDistance(graph, 0, 2));

    }

    static class Node {
        private int data;
        private int distance;

        Node() {
            data = 0;
            distance = 0;
        }

        Node(int data) {
            this.data = data;
            distance = 0;
        }

        Node(int data, int distance) {
            this.data = data;
            this.distance = distance;
        }
    }

    public static int shortestDistance(Map<Integer, List<Integer>> graph, int start, int destination) {
        Set<Integer> visited = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start));

        while(!queue.isEmpty()) {
            Node current = queue.remove();

            if (current.data == destination) {
                return current.distance;
            }

            if (visited.contains(current.data)) {
                continue;
            } else {
                visited.add(current.data);
            }

            for(Integer neighbour :graph.get(current.data)) {
                queue.add(new Node(neighbour, current.distance + 1));
            }
        }

        return 0;
    }
}
