// Floyd Warshall - https://www.naukri.com/code360/problems/flloyd-warshall_2041979?leftPanelTabValue=PROBLEM

// You have been given a directed weighted graph of ‘N’ vertices labeled from 1 to 'N' and ‘M’ edges. Each edge connecting two nodes 'u' and 'v' has a weight 'w' denoting the distance between them.

// Your task is to find the length of the shortest path between the ‘src’ and ‘dest’ vertex given to you in the graph using Floyd warshall’s algorithm. The graph may contain negatively weighted edges.

// Input : n = 4, m = 4, src = 1, dest = 4, edges = [[1, 2, 4,], [1, 3, 3,], [2, 4, 7], [3, 4, -2]]
// Output : 1
// Explanation : The optimal path from source vertex 1 to destination vertex 4 is 1->3->4 with a cost of 3 - 2 = 1.

import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshallAlgorithm {
    public static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int INF = (int) 1e9;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0) - 1;
            int v = it.get(1) - 1;
            int wt = it.get(2);
            dist[u][v] = wt;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        return dist[src - 1][dest - 1];
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int src = 1;
        int dest = 4;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(1, 2, 4)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3, 3)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4, 7)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4, -2)));
        System.out.println(floydWarshall(n, m, src, dest, edges));
        // 1
    }
}
