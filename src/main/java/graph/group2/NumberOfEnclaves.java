package graph.group2;

/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
* */
public class NumberOfEnclaves {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    // 1s connected to the boundary 1s can move out, so answer will be number of 1s not connected to the boundary 1s.
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

//        for (int j = 0; j < m; j++) {
//            if (!visited[0][j] && grid[0][j] == 1) {
//                dfs(0, j, grid, visited);
//            }
//            if (!visited[n - 1][j] && grid[n - 1][j] == 1) {
//                dfs(n - 1, j, grid, visited);
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (!visited[i][0] && grid[i][0] == 1) {
//                dfs(i, 0, grid, visited);
//            }
//            if (!visited[i][m - 1] && grid[i][m - 1] == 1) {
//                dfs(i, m - 1, grid, visited);
//            }
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    // DFS only for boundary 1s
                    if (!visited[i][j] && grid[i][j] == 1) {
                        dfs(i, j, grid, visited);
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(newRow, newCol, grid, visited);
            }
        }
    }
}
