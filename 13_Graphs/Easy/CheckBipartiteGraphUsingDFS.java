// Is Graph Bipartite? - https://leetcode.com/problems/is-graph-bipartite/

// There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

// There are no self-edges (graph[u] does not contain u).
// There are no parallel edges (graph[u] does not contain duplicate values).
// If v is in graph[u], then u is in graph[v] (the graph is undirected).
// The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
// A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

// Return true if and only if it is bipartite.

// Input: graph = [[1,3],[0,2],[1,3],[0,2]]
// Output: true
// Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

public class CheckBipartiteGraphUsingDFS {
    public static boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        for (int i = 0; i < v; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, graph, color))
                    return false;
            }
        }
        return true;
    }

    public static boolean dfs(int node, int c, int[][] graph, int[] color) {
        color[node] = c;
        for (int adjNode : graph[node]) {
            if (color[adjNode] == -1) {
                if (!dfs(adjNode, 1 - c, graph, color))
                    return false;
            } else if (color[adjNode] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        System.out.println(isBipartite(graph));
        // true
    }

}
