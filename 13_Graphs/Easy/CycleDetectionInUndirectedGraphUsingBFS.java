// Cycle Detection In Undirected Graph - https://www.naukri.com/code360/problems/cycle-detection-in-undirected-graph_1062670

// You have been given an undirected graph with 'N' vertices and 'M' edges. The vertices are labelled from 1 to 'N'.

// Your task is to find if the graph contains a cycle or not.

// A path that starts from a given vertex and ends at the same vertex traversing the edges only once is called a cycle.

// Input: edges = n = 3, m = 2, [[1, 2], [2, 3]]
// Output: No
// Explanation: There are a total of 3 vertices in the graph.There is an edge between vertex 1 and 2 and vertex 2 and 3. So, there is no cycle present in the graph. 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int node;
    int parent;

    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class CycleDetectionInUndirectedGraphUsingBFS {
    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Integer>> adj = getAdjacencyList(edges, n);
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            if (!visited[i]) {
                if (bfs(i, visited, adj)) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    private static boolean bfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, -1));
        visited[i] = true;

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.poll();
            for (Integer adjNode : adjacencyList.get(node)) {
                if (!visited[adjNode]) {
                    q.offer(new Pair(adjNode, node));
                    visited[adjNode] = true;
                } else if (adjNode != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayList<ArrayList<Integer>> getAdjacencyList(int[][] edges, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        return adj;
    }

    public static void main(String[] args) {
        int[][] edges = { { 2, 3 }, { 1, 3 } };
        int n = 3;
        int m = edges.length;
        System.out.println(cycleDetection(edges, n, m));
        // No
    }
}
