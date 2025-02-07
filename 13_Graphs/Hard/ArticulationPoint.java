// Articulation Point - https://www.geeksforgeeks.org/problems/articulation-point-1/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=articulation-point

// Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components and return it in sorted manner.
// Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

// Input: n = 5, adj = [[1], [0, 4], [3, 4], [2 ,4], [1, 2, 3]]
// Output: [1, 4]

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPoint {
    static int timer = 1;

    public static ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] mark = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfs(0, -1, adj, visited, tin, low, mark);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i])
                ans.add(i);
        }
        if (ans.size() == 0) {
            ans.add(-1);
            return ans;
        }
        return ans;

    }

    public static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] tin,
            int[] low, boolean[] mark) {
        visited[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for (int adjNode : adj.get(node)) {
            if (adjNode == parent)
                continue;
            if (!visited[adjNode]) {
                child++;
                dfs(adjNode, node, adj, visited, tin, low, mark);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] >= tin[node] && parent != -1)
                    mark[node] = true;
            } else {
                low[node] = Math.min(low[node], tin[adjNode]);
            }
        }
        if (child > 1 && parent == -1)
            mark[node] = true;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(3, 4)));
        adj.add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        System.out.println(articulationPoints(n, adj));
        // [1, 4]
    }
}
