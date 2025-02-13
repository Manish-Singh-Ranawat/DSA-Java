// M-Coloring Problem - https://www.naukri.com/code360/problems/m-coloring-problem_981273?leftPanelTabValue=PROBLEM

// You are given an undirected graph as an adjacency matrix consisting of 'v' vertices and an integer 'm'.

// You need to return 'YES' if you can color the graph using at most 'm' colors so that no two adjacent vertices are the same. Else, return 'NO'.

// Input: mat = [[0, 1, 0], [1, 0, 1], [0, 1, 0]], m = 3.
// Output: YES
// Explanation: The given adjacency matrix tells us that 1 is connected to 2 and 2 is connected to 3. We can use three different colors and color all three nodes.
// Hence we return true.

public class M_ColoringProblem {
    public static String graphColoring(int[][] mat, int m) {
        int n = mat.length;
        int[] color = new int[n];
        return solve(0, n, mat, color, m) ? "YES" : "NO";
    }

    private static boolean solve(int node, int n, int[][] mat, int[] color, int m) {
        if (node == n)
            return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(node, n, mat, color, c)) {
                color[node] = c;
                if (solve(node + 1, n, mat, color, m))
                    return true;
                color[node] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int node, int n, int[][] mat, int[] color, int c) {
        for (int i = 0; i < n; i++) {
            if (mat[node][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };
        int m = 3;
        System.out.println(graphColoring(mat, m));
        // YES
    }
}
