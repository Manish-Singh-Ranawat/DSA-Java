// Shortest Path in DAG - https://www.naukri.com/code360/problems/shortest-path-in-dag_8381897

// You are given a directed acyclic graph of 'N' vertices(0 to 'N' - 1) and 'M' weighted edges.

// Return an array that stores the distance(sum of weights) of the shortest path from vertex 0 to all vertices, and if it is impossible to reach any vertex, then assign -1 as distance.

// Input : 'N' = 3, 'M' = 3, 'edges' = [2, 0, 4], [0, 1, 3], [2, 1, 2]].
// Output : [0, 3, -1]
// Explanation :
// Distance (0 to 0) = 0.
// Distance (0 to 1) = 3.
// Distance (0 to 2) = We cannot reach vertex 2 from 0.
// So our answer is [0, 3, -1].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class ShortestPathInDAG {
    public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = getAdjacencyList(n, m, edges);
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, st);
            }
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair it : adj.get(node)) {
                    int adjNode = it.node;
                    int wt = it.weight;
                    dist[adjNode] = Math.min(dist[adjNode], dist[node] + wt);
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

    public static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (Pair it : adj.get(node)) {
            int adjNode = it.node;
            if (!visited[adjNode]) {
                topoSort(adjNode, adj, visited, st);
            }
        }
        st.push(node);
    }

    public static ArrayList<ArrayList<Pair>> getAdjacencyList(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            int wt = edges[i][2];
            adj.get(v1).add(new Pair(v2, wt));
        }
        return adj;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] edges = { { 2, 0, 4 }, { 0, 1, 3 }, { 2, 1, 2 } };
        int[] res = shortestPathInDAG(n, m, edges);
        System.out.println(Arrays.toString(res));
        // [0, 3, -1]
    }
}
