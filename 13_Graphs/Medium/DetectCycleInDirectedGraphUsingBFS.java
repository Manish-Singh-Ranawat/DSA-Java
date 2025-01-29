// Detect Cycle in a Directed Graph - https://www.naukri.com/code360/problems/detect-cycle-in-a-directed-graph_1542162?leftPanelTabValue=PROBLEM

// Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the given graph contains at least one cycle, else return false.

// Input: v = 4, e = 4, edges = [[0,1], [1,2], [2,3], [3,0]]
// Output: true
// Explanation : From node 0 we can reach 0 again by following this sequence of nodes in the path: 0,1,2,3,0. As we can see in the image below.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraphUsingBFS {
    public static Boolean isCyclic(int[][] edges, int v, int e) {
        ArrayList<ArrayList<Integer>> adj = getAdjacencyList(v, edges);
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
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int adjNode : adj.get(cur)) {
                inDeg[adjNode]--;
                if (inDeg[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }
        return count != v;
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
