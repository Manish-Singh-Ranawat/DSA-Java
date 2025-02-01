// Shortest Path in Weighted undirected graph - https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1?

// You are given a weighted undirected graph having n vertices numbered from 1 to n and m edges along with their weights. Find the shortest weight path between the vertex 1 and the vertex n,  if there exists a path, and return a list of integers whose first element is the weight of the path, and the rest consist of the nodes on that path. If no path exists, then return a list containing a single element -1.

// The input list of edges is as follows - {a, b, w}, denoting there is an edge between a and b, and w is the weight of that edge.

// Note: The driver code here will first check if the weight of the path returned is equal to the sum of the weights along the nodes on that path, if equal it will output the weight of the path, else -2. In case the list contains only a single element (-1) it will simply output -1. 

// Input: n = 5, m = 6, edges = [[1, 2, 2], [2, 5, 5], [2, 3, 4], [1, 4, 1], [4, 3, 3], [3, 5, 1]]
// Output: [5, 1, 4, 3, 5]
// Explanation: Shortest path from 1 to n is by the path 1 4 3 5 whose weight is 5. 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

public class ShortestPathInWeightedUndirectedGraph {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<int[]>> adj = getAdjacencyList(edges, n, m);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        dist[1] = 0;
        pq.offer(new Pair(0, 1));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int curDist = cur.distance;
            int node = cur.node;
            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int weight = it[1];
                if (curDist + weight < dist[adjNode]) {
                    dist[adjNode] = curDist + weight;
                    parent[adjNode] = node;
                    pq.offer(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        path.add(0, dist[n]);
        return path;
    }

    public static ArrayList<ArrayList<int[]>> getAdjacencyList(int[][] edges, int n, int m) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            int wt = edges[i][2];
            adj.get(v1).add(new int[] { v2, wt });
            adj.get(v2).add(new int[] { v1, wt });
        }
        return adj;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int[][] edges = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
        System.out.println(shortestPath(n, m, edges));
        // [5, 1, 4, 3, 5]
    }
}
