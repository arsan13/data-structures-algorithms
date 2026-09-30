package graph.dsu;

/**
 * Disjoint Set Union (Union-Find) with path compression and union by rank/size.
 * Supports near-constant-time connectivity queries over n elements.
 *
 * Time complexity:
 * - Single operation (find/union): amortized O(α(n)) with path compression + rank/size.
 * - O(α(n)) behaves like constant time in practice, but is not strictly O(1) in the theoretical sense.
 * - Sequence of m operations on n elements: O(m · α(n)), where α is the inverse Ackermann function.
 */
public final class DisjointSet {
    private final int[] parent;
    private final int[] rank;  // used for union by rank
    private final int[] size;  // used for union by size
    private final int n;

    public DisjointSet(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be >= 1");
        }
        this.n = n;
        this.parent = new int[n];
        this.rank = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;   // each element is its own parent initially
            rank[i] = 0;     // all trees start with rank 0
            size[i] = 1;     // each set has size 1 initially
        }
    }

    /**
     * Finds the root (representative) of the set that 'node' belongs to,
     * with path compression.
     */
    public int findRoot(int node) {
        validateNode(node);
        if (parent[node] == node) {
            return node;
        }
        // Path compression: directly attach this node to the root.
        parent[node] = findRoot(parent[node]);
        return parent[node];
    }

    /**
     * Union by rank: attach the tree with smaller rank to the tree with larger rank.
     */
    public void unionByRank(int u, int v) {
        int rootU = findRoot(u);
        int rootV = findRoot(v);

        if (rootU == rootV) {
            return; // already in the same set
        }

        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++; // increase rank when both have same rank
        }
    }

    /**
     * Union by size: attach the smaller set to the larger set.
     */
    public void unionBySize(int u, int v) {
        int rootU = findRoot(u);
        int rootV = findRoot(v);

        if (rootU == rootV) {
            return; // already in the same set
        }

        // attach smaller tree under larger tree
        if (size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
    }

    /**
     * Optional helper: check if two elements are in the same set.
     */
    public boolean isConnected(int u, int v) {
        return findRoot(u) == findRoot(v);
    }

    public int countComponents() {
        int count = 0;
        for(int i = 0; i < n; i++){
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    private void validateNode(int node) {
        if (node < 0 || node >= n) {
            throw new IllegalArgumentException("Node out of range: " + node + " (valid range: 0.." + (n - 1) + ")");
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

        ds.unionBySize(0, 1);
        ds.unionBySize(1, 2);
        ds.unionBySize(3, 4);
        ds.unionBySize(5, 6);
        ds.unionBySize(4, 5);

        System.out.println(ds.isConnected(2, 6) ? "Same component" : "Different component");
        ds.unionBySize(2, 6);
        System.out.println(ds.isConnected(2, 6) ? "Same component" : "Different component");
    }
}
