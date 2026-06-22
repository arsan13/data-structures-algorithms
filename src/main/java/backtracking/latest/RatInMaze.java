package backtracking.latest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInMaze {

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        System.out.println(ratInMaze(maze));
    }

    public static List<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        if (maze[0][0] == 1) {
            solve(maze, n, 0, 0, visited, "", result);
        }

        Collections.sort(result);
        return result;
    }

    private static void solve(int[][] maze, int n, int row, int col, boolean[][] visited, String path, List<String> result) {
        if (row == (n - 1) && col == (n - 1)) {
            result.add(path);
            return;
        }

        visited[row][col] = true;

        if (isSafe(row - 1, col, n, maze, visited)) {
            solve(maze, n, row - 1, col, visited, path.concat("U"), result);
        }
        if (isSafe(row + 1, col, n, maze, visited)) {
            solve(maze, n, row + 1, col, visited, path.concat("D"), result);
        }
        if (isSafe(row, col - 1, n, maze, visited)) {
            solve(maze, n, row, col - 1, visited, path.concat("L"), result);
        }
        if (isSafe(row, col + 1, n, maze, visited)) {
            solve(maze, n, row, col + 1, visited, path.concat("R"), result);
        }

        visited[row][col] = false;
    }

    private static boolean isSafe(int row, int col, int n, int[][] maze, boolean[][] visited) {
        return row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1 && !visited[row][col];
    }
}
