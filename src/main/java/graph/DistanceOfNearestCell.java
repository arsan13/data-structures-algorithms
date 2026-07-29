package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an n x m binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two cells sharing a common edge is 1.
 */
public class DistanceOfNearestCell {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<Triplet> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new Triplet(i, j, 0));
                }
            }
        }

        while (!queue.isEmpty()) {
            Triplet triplet = queue.poll();
            int row = triplet.row;
            int col = triplet.col;
            int distance = triplet.distance;

            dist[row][col] = distance;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new Triplet(newRow, newCol, distance + 1));
                }

            }
        }

        return dist;
    }

    private record Triplet(int row, int col, int distance) {
    }
}
