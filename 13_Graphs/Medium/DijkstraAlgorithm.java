// Dijkstra's shortest path - https://www.naukri.com/code360/problems/dijkstra-s-shortest-path_920469?leftPanelTabValue=PROBLEM

// You have been given an undirected graph of ‘V’ vertices (labeled 0,1,..., V-1) and ‘E’ edges. Each edge connecting two nodes (‘X’,’Y’) will have a weight denoting the distance between node ‘X’ and node ‘Y’.

// Your task is to find the shortest path distance from the source node, which is the node labeled as 0, to all vertices given in the graph.

// Input : v = 5, e = 7, edges = [[0, 1, 7], [0, 2, 1], [0, 3, 2], [1, 2, 3], [1, 3, 5], [1, 4, 1], [3, 4, 7]]
// Output : [0, 4, 1, 2, 5]

// Explanation :  The source node is node 0.
// The shortest distance from node 0 to node 0 is 0.
// The shortest distance from node 0 to node 1 is 4. In the above figure, the green path represents this distance. The path goes from node 0->2->1, giving distance = 1+3=4.
// The shortest distance from node 0 to node 2 is 1. In the above figure, the red path represents this distance. The path goes from node 0->2, giving distance = 1
// The shortest distance from node 0 to node 3 is 2. In the above figure, the pink path represents this distance. The path goes from node 0->3, giving distance = 2.
// The shortest distance from node 0 to node 4 is 5. In the above figure, the yellow path represents this distance. The path goes from node 0->2->1->4, giving distance = 1+3+1=5.

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

public class DijkstraAlgorithm {
    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> edges, int v, int e, int source) {
        ArrayList<ArrayList<int[]>> adj = getAdjacencyList(edges, v, e);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            dist.add(Integer.MAX_VALUE);
        }
        dist.set(source, 0);
        pq.offer(new Pair(0, source));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int curDist = cur.distance;
            int node = cur.node;
            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int weight = it[1];
                if (curDist + weight < dist.get(adjNode)) {
                    dist.set(adjNode, curDist + weight);
                    pq.offer(new Pair(dist.get(adjNode), adjNode));
                }
            }
        }
        return dist;
    }

    public static ArrayList<ArrayList<int[]>> getAdjacencyList(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int v1 = edges.get(i).get(0);
            int v2 = edges.get(i).get(1);
            int wt = edges.get(i).get(2);
            adj.get(v1).add(new int[] { v2, wt });
            adj.get(v2).add(new int[] { v1, wt });
        }
        return adj;
    }

    public static void main(String[] args) {
        int source = 0;
        int v = 5;
        int e = 7;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(List.of(0, 1, 7)));
        edges.add(new ArrayList<>(List.of(0, 2, 1)));
        edges.add(new ArrayList<>(List.of(0, 3, 2)));
        edges.add(new ArrayList<>(List.of(1, 2, 3)));
        edges.add(new ArrayList<>(List.of(1, 3, 5)));
        edges.add(new ArrayList<>(List.of(1, 4, 1)));
        edges.add(new ArrayList<>(List.of(3, 4, 7)));
        System.out.println(dijkstra(edges, v, e, source));
    }
}
