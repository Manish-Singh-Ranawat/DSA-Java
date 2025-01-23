// Graph and Vertices - https://www.geeksforgeeks.org/problems/graph-and-vertices/1?

// Given an integer n representing number of vertices. Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.

// Input: 5
// Output: 1024

public class GraphAndVertices {
    public static long count(int n) {
        long edges = (n * (n - 1)) / 2;
        long graphs = (long) Math.pow(2, edges);
        return graphs;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(count(n));
        // 1024
    }
}
