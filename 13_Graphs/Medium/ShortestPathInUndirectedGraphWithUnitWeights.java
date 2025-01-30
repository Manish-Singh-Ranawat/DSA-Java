// Shortest Path in Undirected - https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

// You are given an adjacency list, adj of Undirected Graph having unit weight of the edges, find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.

// Input: adj[][] = [[1, 3], [0, 2], [1, 6], [0, 4], [3, 5], [4, 6], [2, 5, 7, 8], [6, 8], [7, 6]], src = 0
// Output: [0, 1, 2, 1, 2, 3, 3, 4, 4]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraphWithUnitWeights {
    public static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adjNode : adj.get(node)) {
                if (dist[node] + 1 < dist[adjNode]) {
                    dist[adjNode] = dist[node] + 1;
                    q.offer(adjNode);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<>(Arrays.asList(1, 6)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(3, 5)));
        adj.add(new ArrayList<>(Arrays.asList(4, 6)));
        adj.add(new ArrayList<>(Arrays.asList(2, 5, 7, 8)));
        adj.add(new ArrayList<>(Arrays.asList(6, 8)));
        adj.add(new ArrayList<>(Arrays.asList(7, 6)));
        int src = 0;
        int[] res = shortestPath(adj, src);
        System.out.println(Arrays.toString(res));
        // [0, 1, 2, 1, 2, 3, 3, 4, 4]
    }
}
