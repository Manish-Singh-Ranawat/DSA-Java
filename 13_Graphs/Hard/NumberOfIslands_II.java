// Number of Islands II - https://www.naukri.com/code360/problems/number-of-islands-ii_1266048?leftPanelTabValue=PROBLEM

// You have a 2D grid of ‘N’ rows and ‘M’ columns which are initially filled with water. You are given ‘Q’ queries each consisting of two integers ‘X’ and ‘Y’ and in each query operation, you have to turn the water at position (‘X’, ‘Y’) into a land. You are supposed to find the number of islands in the grid after each query.

// An island is a group of lands surrounded by water horizontally, vertically, or diagonally.

// Input : n = 3, m = 3, q = [[0, 0], [0, 1], [1, 2], [2, 1], [4, 5]]
// Output : [1, 1, 2, 3]

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

public class NumberOfIslands_II {
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        DisjointSet ds = new DisjointSet(n * m);
        boolean[][] visited = new boolean[n][m];
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int len = q.length;
        int[] ans = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            int row = q[i][0];
            int col = q[i][1];
            if (visited[row][col]) {
                ans[i] = count;
                continue;
            }
            count++;
            visited[row][col] = true;
            for (int[] it : directions) {
                int nr = row + it[0];
                int nc = col + it[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && visited[nr][nc]) {
                    int node = row * m + col;
                    int adjNode = nr * m + nc;
                    if (ds.unionBySize(node, adjNode))
                        count--;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] q = { { 0, 0 }, { 0, 1 }, { 1, 2 }, { 2, 1 } };
        System.out.println(Arrays.toString(numOfIslandsII(n, m, q)));
        // [1, 1, 2, 3]
    }
}
