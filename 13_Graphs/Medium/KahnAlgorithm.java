// Topological sort - https://www.naukri.com/code360/problems/topological-sort_982938

// Given an adjacency list for a Directed Acyclic Graph (DAG) where adj[u] contains a list of all vertices v such that there exists a directed edge u -> v. Return topological sort for the given graph.

// Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
// Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be 1 else 0.

// Input: v = 4, e = 3, edges = [[1,0], [2,0], [3,0]]
// Output: 1
// Explanation: The output 1 denotes that the order is valid. Few valid Topological orders for the given graph are:
// [3, 2, 1, 0]
// [1, 2, 3, 0]
// [2, 3, 1, 0]

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgorithm {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        ArrayList<ArrayList<Integer>> adj = getAdjacencyList(v, e, edges);
        int[] inDeg = new int[v];
        for (int i = 0; i < v; i++) {
            for (int adjNode : adj.get(i)) {
                inDeg[adjNode]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            list.add(cur);
            for (int adjNode : adj.get(cur)) {
                inDeg[adjNode]--;
                if (inDeg[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }
        return list;
    }

    public static ArrayList<ArrayList<Integer>> getAdjacencyList(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int v1 = edges.get(i).get(0);
            int v2 = edges.get(i).get(1);
            adj.get(v1).add(v2);
        }
        return adj;
    }

    public static void main(String[] args) {
        int v = 4;
        int e = 3;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(1, 0)));
        edges.add(new ArrayList<>(Arrays.asList(2, 0)));
        edges.add(new ArrayList<>(Arrays.asList(3, 0)));
        System.out.println(topologicalSort(edges, v, e));
        // [3, 2, 1, 0]
    }
}
