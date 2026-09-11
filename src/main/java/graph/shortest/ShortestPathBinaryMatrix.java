package graph.shortest;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
    The length of a clear path is the number of visited cells of this path.
* */
public class ShortestPathBinaryMatrix {

    private static final int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    // // Since, moving to a new cell is just a unit weight, BFS with regular Queue is enough. Otherwise, Dijkstra algorithm(PQ) should be used.
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        return shortestPathBinaryMatrix(new Cell(0, 0), new Cell(n - 1, n - 1), grid);
    }

    private int shortestPathBinaryMatrix(Cell src, Cell dest, int[][] grid) {
        int n = grid.length;

        Queue<Cell> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[n][n];

        queue.offer(new Cell(src.row, src.col));
        visited[src.row][src.col] = true;

        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                Cell cell = queue.poll();

                if (cell.row == dest.row && cell.col == dest.col) {
                    return dist;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = cell.row + dx[i];
                    int ny = cell.col + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] == 1 || visited[nx][ny]) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    queue.offer(new Cell(nx, ny));
                }
            }

            dist++;
        }

        return -1;
    }

    private record Cell(int row, int col) {
    }
}
