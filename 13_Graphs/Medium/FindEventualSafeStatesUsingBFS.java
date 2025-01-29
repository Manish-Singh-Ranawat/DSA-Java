// Find Eventual Safe States - https://leetcode.com/problems/find-eventual-safe-states/

// There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

// A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

// Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

// Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
// Output: [2,4,5,6]
// Explanation: Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
// Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStatesUsingBFS {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            revAdj.add(new ArrayList<Integer>());
        }
        int[] inDeg = new int[v];
        for (int i = 0; i < v; i++) {
            for (int adjNode : graph[i]) {
                revAdj.get(adjNode).add(i);
                inDeg[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            list.add(cur);
            for (int adjNode : revAdj.get(cur)) {
                inDeg[adjNode]--;
                if (inDeg[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        System.out.println(eventualSafeNodes(graph));
        // [2, 4, 5, 6]
    }
}
