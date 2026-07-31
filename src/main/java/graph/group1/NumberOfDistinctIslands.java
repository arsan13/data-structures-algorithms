package graph.group1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {

    private static final int[] dx = {0, 1, 0, -1, 0};
    private static final int[] dy = {1, 0, -1, 0, 0};

    public int numIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Set<List<Pair>> islands = new HashSet<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<Pair> island = new ArrayList<>();
                    dfs(i, j, grid, visited, i, j, island);
                    islands.add(island);
                }
            }
        }

        return islands.size();
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visited, int row0, int col0, List<Pair> island) {
        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = true;
        island.add(new Pair(row - row0, col -  col0));

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(newRow, newCol, grid, visited, row0, col0, island);
            }
        }
    }

    private record Pair(int row, int col) {
    }
}
