// DFS Traversal - https://www.naukri.com/code360/problems/dfs-traversal_630462

// Given an undirected and disconnected graph G(V, E), containing 'V' vertices and 'E' edges, the information about edges is given using 'GRAPH' matrix, where i-th edge is between GRAPH[i][0] and GRAPH[i][1]. print its DFS traversal.

// V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
// E is the number of edges present in graph G.

// Note : The Graph may not be connected i.e there may exist multiple components in a graph.

// Input: v = 5, e = 4, edges = [[0, 2], [0, 1], [1, 2], [3, 4]]
// Output: [[0, 1, 2], [3, 4]]
// Explanation: Starting from 0, the DFS traversal proceeds as follows: 
// Visit 0 → Output: 0 
// Visit 2 (the first neighbor of 0) → Output: 0, 2 
// Visit 4 (the first neighbor of 2) → Output: 0, 2, 4 
// Backtrack to 2, then backtrack to 0, and visit 3 → Output: 0, 2, 4, 3 
// Finally, backtrack to 0 and visit 1 → Final Output: 0, 2, 4, 3, 1

import java.util.ArrayList;
import java.util.Arrays;

public class DepthFirstSearch {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = getAdjacencyList(v, edges);
        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArrayList<Integer> list = new ArrayList<>();
                dfs(i, list, visited, adj);
                ans.add(list);
            }
        }
        return ans;
    }

    public static void dfs(int node, ArrayList<Integer> list, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        list.add(node);
        for (Integer neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, list, visited, adj);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> getAdjacencyList(int v, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        return adj;
    }

    public static void main(String[] args) {
        int v = 5;
        int e = 4;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4)));
        System.out.println(depthFirstSearch(v, e, edges));
        // [[0, 1, 2], [3, 4]]
    }
}
