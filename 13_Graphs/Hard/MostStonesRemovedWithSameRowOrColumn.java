// Most Stones Removed with Same Row or Column - https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/

// On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

// A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

// Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.

// Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
// Output: 5

// Explanation: One way to remove 5 stones is as follows:
// 1. Remove stone [2,2] because it shares the same row as [2,1].
// 2. Remove stone [2,1] because it shares the same column as [0,1].
// 3. Remove stone [1,2] because it shares the same row as [1,0].
// 4. Remove stone [1,0] because it shares the same column as [0,0].
// 5. Remove stone [0,1] because it shares the same row as [0,0].
// Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.

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

public class MostStonesRemovedWithSameRowOrColumn {
    public static int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int[] it : stones) {
            maxRow = Math.max(maxRow, it[0]);
            maxCol = Math.max(maxCol, it[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashSet<Integer> set = new HashSet<>();
        for (int[] it : stones) {
            int r = it[0];
            int c = it[1] + maxRow + 1;
            ds.unionBySize(r, c);
            set.add(r);
            set.add(c);
        }
        int count = 0;
        for (int it : set) {
            if (ds.findParent(it) == it)
                count++;
        }
        return n - count;
    }

    public static void main(String[] args) {
        int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        System.out.println(removeStones(stones));
        // 5
    }
}
