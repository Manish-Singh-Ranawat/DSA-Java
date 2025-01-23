// Creating and Printing - https://www.naukri.com/code360/problems/create-a-graph-and-print-it_1214551?leftPanelTabValue=PROBLEM

// You are given an undirected graph of 'N' nodes and 'M' edges. Your task is to create the graph and print the adjacency list of the graph. It is guaranteed that all the edges are unique, i.e., if there is an edge from 'X' to 'Y', then there is no edge present from 'Y' to 'X' and vice versa. Also, there are no self-loops present in the graph.

// In graph theory, an adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a vertex in the graph.

// Input : n = 4, m = 3 , edges = [[1, 2], [0, 3], [2, 3]] 
// Output : [[0, 3], [1, 2], [2, 1, 3], [3, 0, 2]]
// Explanation : The neighbor of node 0 is 3. So, in the first line, the first integer is 0 followed by its neighbor 3. Similarly in the second line, 1 is followed by its neighbor 2. 
// In the third line, 2 is followed by its neighbors 1 and 3. And in the fourth line, 3 is followed by its neighbors 0 and 2.

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AdjacencyList {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        int[][] mat = new int[n][];
        for (int i = 0; i < n; i++) {
            List<Integer> cur = adj.get(i);
            cur.add(0, i);
            int k = cur.size();
            mat[i] = new int[k];
            for (int j = 0; j < k; j++) {
                mat[i][j] = cur.get(j);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 3;
        int[][] edges = { { 1, 2 }, { 0, 3 }, { 2, 3 } };
        int[][] res = printAdjacency(n, m, edges);
        for (int i = 0; i < n; i++) {
            System.out.print(Arrays.toString(res[i])+" ");
        }
        // [0, 3] [1, 2] [2, 1, 3] [3, 0, 2] 
    }
}
