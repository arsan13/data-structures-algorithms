package graph.shortest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumEffortPath {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Triplet> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.effort));
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        queue.offer(new Triplet(0, 0, 0));
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Triplet triplet = queue.poll();

            if (triplet.row == n - 1 && triplet.col == m - 1) {
                return triplet.effort;
            }

            for (int i = 0; i < 4; i++) {
                int nx = triplet.row + dx[i];
                int ny = triplet.col + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                int newEffort = Math.max(Math.abs(heights[triplet.row][triplet.col] - heights[nx][ny]), triplet.effort);
                if (newEffort < dist[nx][ny]) {
                    dist[nx][ny] = newEffort;
                    queue.offer(new Triplet(nx, ny, newEffort));
                }
            }
        }

        return 0;
    }

    private record Triplet(int row, int col, int effort) {}
}
