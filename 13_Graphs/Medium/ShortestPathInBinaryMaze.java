// Shortest Path In A Binary Maze - https://www.naukri.com/code360/problems/shortest-path-in-a-binary-maze_893065?leftPanelTabValue=PROBLEM

// Given a maze in the form of a binary rectangular matrix of size M*N, where each element can either be 0 or 1, the task is to find the length of the shortest path in a maze from a given source cell to a destination cell.

// The path can only be created out of a cell if its value is 1 and at any given moment, we can only move one step in one of the four directions. The valid moves are:
// Up: (x, y) -> (x - 1, y)
// Left: (x, y) -> (x, y - 1)
// Down: (x, y) -> (x + 1, y)
// Right: (x, y) -> (x, y + 1)
// If there is no path from a given source cell to a destination cell, return -1.

// Input : matrix = [[1, 1, 1, 1], [0, 1, 1, 0], [0, 0, 1, 1]], src = [0,0], dest = [2,3]
// Output : 5
// Explanation : The shortest path between the source cell (0, 0) and destination cell (2,3) is highlighted in the figure below, having a length of 5.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//   Following is the Point Class structure
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Tuple {
    int distance;
    int row;
    int col;

    Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

public class ShortestPathInBinaryMaze {
    public static int shortestPathBinaryMatrix(int[][] matrix, Point src, Point dest) {
        if (matrix[src.x][src.y] == 0 || matrix[dest.x][dest.y] == 0)
            return -1;
        if (src.x == dest.x && src.y == dest.y)
            return 0;
        Queue<Tuple> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[src.x][src.y] = 0;
        q.offer(new Tuple(0, src.x, src.y));
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            Tuple cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            int curDist = cur.distance;
            for (int i = 0; i < 4; i++) {
                int nr = row + directions[i][0];
                int nc = col + directions[i][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] == 1 && curDist + 1 < dist[nr][nc]) {
                    dist[nr][nc] = curDist + 1;
                    if (nr == dest.x && nc == dest.y)
                        return dist[nr][nc];
                    q.offer(new Tuple(dist[nr][nc], nr, nc));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1, 1 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 } };
        Point src = new Point(0, 0);
        Point dest = new Point(2, 3);
        System.out.println(shortestPathBinaryMatrix(matrix, src, dest));
        // 5
    }
}
