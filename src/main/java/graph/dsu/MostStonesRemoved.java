package graph.dsu;

import java.util.HashSet;
import java.util.Set;

/*
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
 */
public class MostStonesRemoved {

    /*
    Answer = total stones - number of groups (stones linked by shared row/column).

    Let g = number of groups, sizes k1..kg, so  k1 + k2 + ... + kg = total.
    Groups share no row/column, so solve each independently.

    Per group of size k:
      removed <= k - 1   (the last stone has no neighbour, so >= 1 must stay)
      removed >= k - 1   (DFS spanning tree: remove children before parents; parent is always still present)
      => removed = k - 1

    Total removed = (k1 - 1) + (k2 - 1) + ... + (kg - 1)
                  = (k1 + k2 + ... + kg) - g
                  = total - g

    DSU: nodes are rows and columns; stone (r, c) unions row r with column c.
     */
    public int removeStones(int[][] stones) {
        // Largest row index and largest column index, used to size the DSU.
        int n = 0;
        int m = 0;

        for (int[] stone : stones) {
            n = Math.max(n, stone[0]);
            m = Math.max(m, stone[1]);
        }

        // Row nodes occupy indices 0..n; column nodes occupy n+1..n+m+1 (column c -> c + n + 1).
        // The offset keeps the two ranges from overlapping. Total nodes = (n + 1) + (m + 1).
        DisjointSet ds = new DisjointSet(n + m + 2);

        // Only rows/columns that actually hold a stone; other DSU indices are unused singletons
        // and must not be counted as components.
        Set<Integer> set = new HashSet<>();

        for (int[] stone : stones) {
            int rowNode = stone[0];
            int colNode = stone[1] + n + 1;
            // This stone links its row and its column into one group.
            ds.unionBySize(rowNode, colNode);
            set.add(rowNode);
            set.add(colNode);
        }

        // Each group has exactly one root, so counting roots among used nodes counts the groups.
        int components = 0;
        for (int item : set) {
            if (ds.findRoot(item) == item) {
                components++;
            }
        }

        // Keep one stone per group, remove the rest.
        return stones.length - components;
    }
}
