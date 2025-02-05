// Find the Number of Provinces - https://www.naukri.com/code360/problems/find-the-number-of-states_1377943?

// You are given ‘n’ cities, some of which are connected by bidirectional roads. You are also given an ‘n x n’ matrix i.e. ‘roads’, where if city ‘i’ and ‘j’ are connected by a road then ‘roads[i][j]'= 1, otherwise ‘roads[i][j]' = 0.

// A province is a group of cities that are either directly or indirectly connected to each other through roads.
// The goal is to count and return the total number of such provinces in the given matrix.

// Input : n = 4, roads = [[1, 1, 1, 0], [1, 1, 1, 0], [1, 1, 1, 0], [0, 0, 0, 1]]
// Output : 2

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

public class NumberOfProvinces {
    public static int findNumOfProvinces(int[][] roads, int n) {
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (roads[i][j] == 1)
                    ds.unionBySize(i, j);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = { { 1, 1, 1, 0 },
                { 1, 1, 1, 0 },
                { 1, 1, 1, 0 },
                { 0, 0, 0, 1 } };
        System.out.println(findNumOfProvinces(roads, n));
        // 2
    }
}
