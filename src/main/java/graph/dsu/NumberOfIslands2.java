package graph.dsu;

import java.util.ArrayList;
import java.util.List;

/*
Given a grid of n rows and m columns. Initially, all cells of the grid contain 0, where 0 represents water.

You are also given a 2D array operators[][] of size k, where each operator contains two integers representing the row and column of a cell.
Each operation converts the specified water cell into land by changing its value from 0 to 1.
Return an array containing the number of islands after each operation.

An island is a group of one or more land cells (or 1s) with the following properties,

1s are connected through their top, bottom, left, or right sides.
Diagonally connected are not considered part of the same island.

Link: https://www.geeksforgeeks.org/problems/number-of-islands/1
 */
public class NumberOfIslands2 {

    private static final int[] dRow = new int[]{-1, 1, 0, 0};
    private static final int[] dCol = new int[]{0, 0, -1, 1};

    // Intuition: a new land cell starts as its own island (count++). Each time it touches a land
    // neighbor in a *different* component, two islands merge into one (count--).
    // Time: O(k * alpha(n*m)), Space: O(n*m)
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        List<Integer> res = new ArrayList<>();
        DisjointSet ds = new DisjointSet(n * m);
        boolean[][] isLand = new boolean[n][m];
        int count = 0;

        for (int[] operator : operators) {
            int row = operator[0];
            int col = operator[1];

            // Duplicate operator: already land, nothing changes.
            if (isLand[row][col]) {
                res.add(count);
                continue;
            }

            isLand[row][col] = true;
            count++;

            // Flatten (row, col) into a single DSU node id.
            int node = row * m + col;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if (isValid(newRow, newCol, n, m) && isLand[newRow][newCol]) {
                    int adjNode = newRow * m + newCol;

                    // Same root => already merged (e.g. two neighbours of this cell share an
                    // island), so don't decrement again.
                    if (ds.findRoot(node) != ds.findRoot(adjNode)) {
                        count--;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }

            res.add(count);
        }

        return res;
    }

    private boolean isValid(int newRow, int newCol, int n, int m) {
        return newRow >= 0 && newRow < n && newCol >= 0 && newCol < m;
    }

    public static void main(String[] args) {
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1}};
        // Expected: [1, 1, 2, 1, 1]
        System.out.println(new NumberOfIslands2().numOfIslands(4, 5, operators));
    }
}
