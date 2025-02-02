// Cheapest Flights Within K Stops - https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

// There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

// Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
// Output: 700
// Explanation: The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
// Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Tuple {
    int stops;
    int node;
    int distance;

    Tuple(int stops, int node, int distance) {
        this.stops = stops;
        this.node = node;
        this.distance = distance;
    }
}

public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = getAdjacencyList(n, flights);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.stops - b.stops);
        pq.offer(new Tuple(0, src, 0));
        dist[src] = 0;
        while (!pq.isEmpty()) {
            Tuple cur = pq.poll();
            int node = cur.node;
            int stops = cur.stops;
            int curDist = cur.distance;
            if (stops > k)
                continue;
            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int wt = it[1];
                if (curDist + wt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = curDist + wt;
                    pq.offer(new Tuple(stops + 1, adjNode, dist[adjNode]));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static ArrayList<ArrayList<int[]>> getAdjacencyList(int n, int[][] flights) {
        int m = flights.length;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<int[]>());
        }
        for (int i = 0; i < m; i++) {
            int v1 = flights[i][0];
            int v2 = flights[i][1];
            int wt = flights[i][2];
            adj.get(v1).add(new int[] { v2, wt });
        }
        return adj;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
        // 700
    }
}