package graph.shortest.algorithm;

import java.util.Arrays;

/*
This is a multi-source shortest path algorithm: it finds the shortest distance between every pair of nodes,
not just from a single source.
It works only on directed graphs, so an undirected graph must first be converted into one
(each undirected edge becomes two directed edges).
It is a brute force (DP) algorithm.
It can also detect a negative weight cycle: if it exists, the shortest "distance" from some node back to
itself comes out negative.
matrix[i][j] is the direct edge weight from i to j, or -1 if there is no direct edge; the method mutates
matrix in place into the all-pairs shortest distance matrix (still using -1 for "still unreachable").
Time: O(V^3), Space: O(1) extra.
If there are no negative edge weights, Dijkstra is a better choice: just run Dijkstra from every node
(O(V * E log V) overall), instead of this O(V^3) brute force.
 */
public class FloydWarshallAlgorithm {

    public void shortestDistance(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // -1 is the input's "no direct edge" sentinel; treat it as infinity for the relaxation below.
                if (matrix[i][j] == -1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                if (i == j) {
                    matrix[i][j] = 0; // Distance to itself is 0 (no self-loop assumed).
                }
            }
        }

        // Try every node k as an intermediate hop between every pair (i, j).
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // i or k is still unreached, so there's nothing to relax through it
                    // (also avoids overflowing MAX_VALUE + weight below).
                    if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // Set back -1 for still-unreachable pairs.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    // A negative weight cycle exists iff some node's shortest "distance" back to itself is negative.
    public boolean hasCycle(int[][] matrix) {
        int n = matrix.length;
        shortestDistance(matrix);
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] < 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FloydWarshallAlgorithm algo = new FloydWarshallAlgorithm();

        int[][] matrix = {
                {0, 2, -1, -1},
                {1, 0, 3, -1},
                {-1, -1, 0, 2},
                {-1, -1, -1, 0}
        };
        algo.shortestDistance(matrix);
        System.out.println("All-pairs shortest distances:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        int[][] negativeCycleMatrix = {
                {0, 1, -1},
                {-1, 0, -2},
                {-3, -1, 0}
        };
        System.out.println("Has negative cycle: " + algo.hasCycle(negativeCycleMatrix));
    }
}
