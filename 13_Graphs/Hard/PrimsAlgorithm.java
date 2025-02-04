// Prim's MST - https://www.naukri.com/code360/problems/prim-s-mst_1095633?leftPanelTabValue=PROBLEM

// You are given an undirected connected weighted graph having ‘N’ nodes numbered from 1 to 'N'. A matrix ‘E’ of size M x 2 is given which represents the ‘M’ edges such that there is an edge directed from node E[i][0] to node E[i][1]. You are supposed to return the minimum spanning tree where you need to return weight for each edge in the MST.

// Input : n = 5, m = 14, edges = [[1, 2, 2], [1, 4, 6], [2, 1, 2], [2, 3, 3], [2, 4, 8], [2, 5, 5], [3, 2, 3], [3, 5, 7], [4, 1, 6], [4, 2, 8], [4, 5, 9], [5, 2, 5], [5, 3, 7], [5, 4, 9]]

// Output : [[1, 2, 2], [2, 3, 3], [2, 5, 5], [1, 4, 6]]

// Explanation : The Minimum spanning tree for the given graph will contain the edges: (1,2) with weight 2, (1,4) with weight 6, (2,3) with weight 3 and (2,5) with weight 5.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Tuple {
    int weight;
    int node;
    int parent;

    Tuple(int weight, int node, int parent) {
        this.weight = weight;
        this.node = node;
        this.parent = parent;
    }
}

public class PrimsAlgorithm {
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        ArrayList<ArrayList<int[]>> adj = getAdjacencyList(n, edges);
        boolean[] visited = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> mst = new ArrayList<>();
        pq.offer(new Tuple(0, 1, -1));
        while (!pq.isEmpty()) {
            Tuple cur = pq.poll();
            int node = cur.node;
            int parent = cur.parent;
            int weight = cur.weight;
            if (visited[node])
                continue;
            visited[node] = true;
            if (parent != -1) {
                mst.add(new ArrayList<>(Arrays.asList(parent, node, weight)));
            }
            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int wt = it[1];
                if (!visited[adjNode]) {
                    pq.offer(new Tuple(wt, adjNode, node));
                }
            }
        }
        return mst;
    }

    public static ArrayList<ArrayList<int[]>> getAdjacencyList(int n, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            adj.get(u).add(new int[] { v, wt });
            adj.get(v).add(new int[] { u, wt });
        }
        return adj;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 14;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(1, 2, 2)));
        edges.add(new ArrayList<>(Arrays.asList(1, 4, 6)));
        edges.add(new ArrayList<>(Arrays.asList(2, 1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 3, 3)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4, 8)));
        edges.add(new ArrayList<>(Arrays.asList(2, 5, 5)));
        edges.add(new ArrayList<>(Arrays.asList(3, 2, 3)));
        edges.add(new ArrayList<>(Arrays.asList(3, 5, 7)));
        edges.add(new ArrayList<>(Arrays.asList(4, 1, 6)));
        edges.add(new ArrayList<>(Arrays.asList(4, 2, 8)));
        edges.add(new ArrayList<>(Arrays.asList(4, 5, 9)));
        edges.add(new ArrayList<>(Arrays.asList(5, 2, 5)));
        edges.add(new ArrayList<>(Arrays.asList(5, 3, 7)));
        edges.add(new ArrayList<>(Arrays.asList(5, 4, 9)));
        System.out.println(calculatePrimsMST(n, m, edges));
        // [[1, 2, 2], [2, 3, 3], [2, 5, 5], [1, 4, 6]]
    }
}
