package graph.dsu;

import java.util.HashSet;
import java.util.Set;

/*
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
Return the size of the largest island in grid after applying this operation.
An island is a 4-directionally connected group of 1s.

Intuition:
  Flipping a 0 merges all distinct islands touching it (up to 4) into one, plus the cell itself.
  So if every island's size is known up front, the result of flipping a 0 is
  1 + sum of sizes of the distinct neighbouring islands. A DSU gives both the island id (root)
  and its size in near-constant time.

Time complexity: O(n^2 * α(n^2)) ~ O(n^2)
  - Building islands: n^2 cells, up to 4 unions each.
  - Evaluating flips: n^2 cells, up to 4 finds each.
  - α is the inverse Ackermann function (practically constant).
Space complexity: O(n^2) for the DSU arrays (plus O(1) for the per-cell set of at most 4 roots).
 */
public class LargestIsland {

    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet islands = buildIslands(grid, n);

        int largest = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int size = grid[row][col] == 1
                        ? islands.getSize(islands.findRoot(row * n + col))
                        : sizeIfFlipped(grid, islands, row, col, n);
                largest = Math.max(largest, size);
            }
        }
        return largest;
    }

    // Step 1: union every land cell with its land neighbours so each island becomes one component.
    private DisjointSet buildIslands(int[][] grid, int n) {
        DisjointSet islands = new DisjointSet(n * n);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int newRow = row + dRow[k];
                    int newCol = col + dCol[k];
                    if (isLand(grid, newRow, newCol, n)) {
                        islands.unionBySize(row * n + col, newRow * n + newCol);
                    }
                }
            }
        }
        return islands;
    }

    // Step 2: size of the island formed by turning (row, col) into land.
    // A set of roots ensures an island touching the cell from several sides is counted once.
    private int sizeIfFlipped(int[][] grid, DisjointSet islands, int row, int col, int n) {
        Set<Integer> neighbourIslands = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int newRow = row + dRow[k];
            int newCol = col + dCol[k];
            if (isLand(grid, newRow, newCol, n)) {
                neighbourIslands.add(islands.findRoot(newRow * n + newCol));
            }
        }

        int size = 1; // the flipped cell itself
        for (int root : neighbourIslands) {
            size += islands.getSize(root);
        }
        return size;
    }

    private boolean isLand(int[][] grid, int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 1;
    }

    public static void main(String[] args) {
        LargestIsland solution = new LargestIsland();
        System.out.println(solution.largestIsland(new int[][]{{1, 0}, {0, 1}})); // 3
        System.out.println(solution.largestIsland(new int[][]{{1, 1}, {1, 0}})); // 4
        System.out.println(solution.largestIsland(new int[][]{{1, 1}, {1, 1}})); // 4
        System.out.println(solution.largestIsland(new int[][]{{0}}));             // 1
    }
}
