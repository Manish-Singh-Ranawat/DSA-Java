// BFS in Graph - https://www.naukri.com/code360/problems/bfs-in-graph_973002

// Given an adjacency list representation of a directed graph with ‘n’ vertices and ‘m’ edges. Your task is to return a list consisting of Breadth-First Traversal (BFS) starting from vertex 0.

// In this traversal, one can move from vertex 'u' to vertex 'v' only if there is an edge from 'u' to 'v'. The BFS traversal should include all nodes directly or indirectly connected to vertex 0.

// Note: The traversal should proceed from left to right according to the input adjacency list.

// Input: n = 5, adj = [[2, 3, 1], [0], [0, 4], [0], [2]]
// Output: [0, 2, 3, 1, 4]
// Explanation: Starting from 0, the BFS traversal will follow these steps: 
// Visit 0 → Output: 0 
// Visit 2 (first neighbor of 0) → Output: 0, 2 
// Visit 3 (next neighbor of 0) → Output: 0, 2, 3 
// Visit 1 (next neighbor of 0) → Output: 0, 2, 3, 
// Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;
        ArrayList<Integer> bfs = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            bfs.add(cur);
            for (int i : adj.get(cur)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        System.out.println(bfsTraversal(n, adj));
        // [0, 2, 3, 1, 4]
    }
}
