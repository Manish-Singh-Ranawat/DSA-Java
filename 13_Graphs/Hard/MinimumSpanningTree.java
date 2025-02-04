// Minimum Spanning Tree - https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

// Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph. 

// Input : V = 3, E = 3, edges = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]
// Output: 4

import java.util.*;

class Pair {
    int weight;
    int node;

    Pair(int weight, int node) {
        this.weight = weight;
        this.node = node;
    }
}

public class MinimumSpanningTree {
    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[V];
        pq.offer(new Pair(0, 0));
        int sum = 0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int weight = cur.weight;
            if (visited[node])
                continue;
            visited[node] = true;
            sum += weight;
            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int wt = it[1];
                if (!visited[adjNode]) {
                    pq.offer(new Pair(wt, adjNode));
                }
            }
        }
        return sum;
    }

    public static List<List<int[]>> getAdjacencyList(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            adj.get(u).add(new int[] { v, wt });
            adj.get(v).add(new int[] { u, wt });
        }
        return adj;
    }

    public static void main(String[] args) {
        int V = 3;
        int E = 3;
        int[][] edges = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };
        List<List<int[]>> adj = getAdjacencyList(V, edges);
        System.out.println(spanningTree(V, E, adj));
        // 4
    }
}
