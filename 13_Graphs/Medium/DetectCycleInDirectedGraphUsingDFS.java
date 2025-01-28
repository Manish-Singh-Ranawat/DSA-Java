// Detect Cycle in a Directed Graph - https://www.naukri.com/code360/problems/detect-cycle-in-a-directed-graph_1542162?leftPanelTabValue=PROBLEM

// Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the given graph contains at least one cycle, else return false.

// Input: v = 4, e = 4, edges = [[0,1], [1,2], [2,3], [3,0]]
// Output: true
// Explanation : From node 0 we can reach 0 again by following this sequence of nodes in the path: 0,1,2,3,0. As we can see in the image below.

import java.util.ArrayList;

public class DetectCycleInDirectedGraphUsingDFS {
    public static boolean isCyclic(int[][] edges, int v, int e) {
        ArrayList<ArrayList<Integer>> adj = getAdjacencyList(v, edges);
        boolean[] visited = new boolean[v];
        boolean[] pathVisited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited))
                    return true;
            }
        }
        return false;

    }

    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                if (dfs(adjNode, adj, visited, pathVisited))
                    return true;
            } else if (pathVisited[adjNode]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }

    public static ArrayList<ArrayList<Integer>> getAdjacencyList(int V, int edges[][]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int e = edges.length;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            adj.get(v1).add(v2);
        }
        return adj;
    }

    public static void main(String[] args) {
        int v = 4;
        int e = 4;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
        System.out.println(isCyclic(edges, v, e));
        // true
    }
}
