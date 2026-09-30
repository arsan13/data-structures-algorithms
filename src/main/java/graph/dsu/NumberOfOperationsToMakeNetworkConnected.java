package graph.dsu;

/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
 */
public class NumberOfOperationsToMakeNetworkConnected {

    // Key insight: a redundant edge (both endpoints already in the same component)
    // can be "moved" to bridge two disconnected components. To connect C components
    // into one, you need exactly C-1 such moves.
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];

            if (ds.findRoot(u) == ds.findRoot(v)) {
                extraEdges++;  // cycle edge — available to relocate
            } else {
                ds.unionBySize(u, v);
            }
        }

        int edgesRequired = ds.countComponents() - 1;  // bridges needed = components - 1
        if (extraEdges >= edgesRequired) {
            return edgesRequired;
        }

        return -1;  // not enough spare edges to bridge all components
    }

    public static void main(String[] args) {
        var sol = new NumberOfOperationsToMakeNetworkConnected();

        // 4 computers, 3 edges with one redundant — need 1 move
        System.out.println(sol.makeConnected(4, new int[][]{{0,1},{0,2},{1,2}})); // 1

        // 6 computers, 5 edges — need 2 moves
        System.out.println(sol.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2}})); // -1 (not enough edges)

        // Already connected
        System.out.println(sol.makeConnected(3, new int[][]{{0,1},{0,2}})); // 0

        // Impossible: fewer than n-1 edges
        System.out.println(sol.makeConnected(4, new int[][]{{0,1},{2,3}})); // -1
    }
}
