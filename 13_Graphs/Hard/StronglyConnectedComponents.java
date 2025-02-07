// Count Strongly Connected Components (Kosaraju’s Algorithm) - https://www.naukri.com/code360/problems/count-strongly-connected-components-kosaraju-s-algorithm_1171151?leftPanelTabValue=PROBLEM

// You are given an unweighted directed graph having 'V' vertices and 'E' edges. Your task is to count the number of strongly connected components (SCCs) present in the graph.

// A directed graph is said to be strongly connected if every vertex is reachable from every other vertex. The strongly connected components of a graph are the subgraphs which are themselves strongly connected.

// Note : Use zero-based indexing for the vertices.
// The given graph doesn’t contain any self-loops.

// Input : v = 5,  edges = [[0, 1] ,[1, 2], [1, 4], [2, 3], [3, 2], [4, 0]]
// Output : 2

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponents {
    public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = getAdjacencyList(v, edges, false);
        boolean[] visited = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i])
                dfs(i, adj, visited, st);
        }
        ArrayList<ArrayList<Integer>> revAdj = getAdjacencyList(v, edges, true);
        visited = new boolean[v];
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!visited[node]) {
                scc++;
                dfs(node, revAdj, visited);
            }
        }
        return scc;
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode])
                dfs(adjNode, adj, visited, st);
        }
        st.push(node);
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> revAdj, boolean[] visited) {
        visited[node] = true;
        for (int adjNode : revAdj.get(node)) {
            if (!visited[adjNode])
                dfs(adjNode, revAdj, visited);
        }
    }

    public static ArrayList<ArrayList<Integer>> getAdjacencyList(int v, ArrayList<ArrayList<Integer>> edges,
            boolean reverse) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> it : edges) {
            int v1 = it.get(0);
            int v2 = it.get(1);
            if (reverse) {
                adj.get(v2).add(v1);
            } else {
                adj.get(v1).add(v2);
            }
        }
        return adj;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1)));
        edges.add(new ArrayList<>(List.of(1, 2)));
        edges.add(new ArrayList<>(List.of(1, 4)));
        edges.add(new ArrayList<>(List.of(2, 3)));
        edges.add(new ArrayList<>(List.of(3, 2)));
        edges.add(new ArrayList<>(List.of(4, 0)));
        System.out.println(stronglyConnectedComponents(v, edges));
        // 2
    }
}
