// Kruskal’s Minimum Spanning Tree Algorithm - https://www.naukri.com/code360/problems/kruskal-s-minimum-spanning-tree-algorithm_1082553?leftPanelTabValue=PROBLEM

// A minimum spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices without any cycles and with the minimum possible total edge weight.

// A spanning tree’s weight is the sum of the weights of each edge in the spanning tree.

// You have been given a connected undirected weighted graph having 'n' vertices, from 1 to 'n', and 'm' edges.
// Each element of 'edges' contains three integers, the two vertices that are being connected and the weight of the edge.

// Find the weight of the minimum spanning tree of the given graph.

// Input: n = 5, m = 6, edges = [[1, 2, 6], [2, 3, 5], [3, 4, 4], [1, 4, 1], [1, 3, 2], [3, 5, 3]]
// Output: 11
// Explanation: The given graph is: [[1, 4, 1], [1 ,3 ,2], [2 ,3 ,5], [3 ,5 ,3]]
// And its weight is 1 + 2 + 5 + 3 = 11.

import java.util.Arrays;

class DisjointSet {
    public int[] rank;
    public int[] size;
    public int[] parent;

    DisjointSet(int n) {
        this.rank = new int[n + 1];
        this.size = new int[n + 1];
        this.parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    public boolean unionByRank(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return false;
        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
            rank[pv]++;
        }
        return true;
    }

    public boolean unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return false;
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        return true;
    }
}

public class KruskalsAlgorithm {
    public static int kruskalMST(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        DisjointSet ds = new DisjointSet(n);
        int ans = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (ds.unionBySize(u, v)) {
                ans += wt;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int[][] edges = { { 1, 2, 6 }, { 2, 3, 5 }, { 3, 4, 4 }, { 1, 4, 1 }, { 1, 3, 2 }, { 3, 5, 3 } };
        System.out.println(kruskalMST(n, edges));
        // 11
    }
}
