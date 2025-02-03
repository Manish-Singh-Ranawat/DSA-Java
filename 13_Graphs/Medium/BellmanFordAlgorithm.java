// Bellman Ford - https://www.naukri.com/code360/problems/bellmon-ford_2041977?leftPanelTabValue=PROBLEM

// You have been given a directed weighted graph of ‘N’ vertices labeled from 1 to 'N' and ‘M’ edges. Each edge connecting two nodes 'u' and 'v' has a weight 'w' denoting the distance between them.

// Your task is to calculate the shortest distance of all vertices from the source vertex 'src'.

// Input : n = 4, m = 4, src = 1, edges = [[1, 2, 4], [1, 3, 3], [2, 4, 7 ], [3, 4, -2]]
// Output : [0, 4, 3, 1]
// Explanation :
// The length of the shortest path between vertex 1 and vertex 1 is 1->1 and the cost is 0.
// The length of the shortest path between vertex 1 and vertex 2 is 1->2 and the cost is 4.
// The length of the shortest path between vertex 1 and vertex 3 is 1->3 and the cost is 3.
// The length of the shortest path between vertex 1 and vertex 4 is 1->3->4 and the cost is 1.
// Hence we return [0, 4, 3, 1].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    public static int[] bellmanFord(int n, int m, int src, List<List<Integer>> edges) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int src = 1;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(1, 2, 4)));
        edges.add(new ArrayList<>(List.of(1, 3, 3)));
        edges.add(new ArrayList<>(List.of(2, 4, 7)));
        edges.add(new ArrayList<>(List.of(3, 4, -2)));
        int[] res = bellmanFord(n, m, src, edges);
        for (int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }
        // 0 4 3 1
    }
}
