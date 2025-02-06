// Making A Large Island - https://leetcode.com/problems/making-a-large-island/description/?envType=daily-question&envId=2025-01-31

// You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

// Return the size of the largest island in grid after applying this operation.

// An island is a 4-directionally connected group of 1s.

// Input: grid = [[1,0],[0,1]]
// Output: 3
// Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.

import java.util.HashMap;
import java.util.HashSet;

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

public class MakingLargeIsland {
    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    for (int[] it : directions) {
                        int nr = row + it[0];
                        int nc = col + it[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int node = row * n + col;
                            int adjNode = nr * n + nc;
                            ds.unionBySize(node, adjNode);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    HashSet<Integer> components = new HashSet<>();
                    for (int[] it : directions) {
                        int nr = row + it[0];
                        int nc = col + it[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int node = nr * n + nc;
                            components.add(ds.findParent(node));
                        }
                    }
                    int size = 1;
                    for (int it : components) {
                        size += ds.size[it];
                    }
                    ans = Math.max(ans, size);
                }
            }
        }
        for (int i = 0; i < n * n; i++) {
            ans = Math.max(ans, ds.size[ds.findParent(i)]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 0 }, { 0, 1 } };
        System.out.println(largestIsland(grid));
        // 3
    }
}
