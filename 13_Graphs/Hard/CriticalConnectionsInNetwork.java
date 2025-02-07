// Critical Connections in a Network - https://leetcode.com/problems/critical-connections-in-a-network/description/

// There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

// A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

// Return all critical connections in the network in any order.

// Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
// Output: [[1,3]]
// Explanation: [[3,1]] is also accepted.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInNetwork {
    static int timer = 1;

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = getAdjacencyList(n, connections);
        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, adj, visited, tin, low, bridges);
        return bridges;
    }

    public static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] tin,
            int[] low, List<List<Integer>> bridges) {
        visited[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        for (int adjNode : adj.get(node)) {
            if (adjNode == parent)
                continue;
            if (!visited[adjNode]) {
                dfs(adjNode, node, adj, visited, tin, low, bridges);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] > tin[node])
                    bridges.add(Arrays.asList(node, adjNode));
            } else {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> getAdjacencyList(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        System.out.println(criticalConnections(n, connections));
        // [[1, 3]]
    }
}
