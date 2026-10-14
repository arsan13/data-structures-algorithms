package graph.tarjan.latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Critical Connections in a Network
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
Return all critical connections in the network in any order.
 */
public class TarjanAlgorithm {

    // Global discovery counter; each node gets the next value when first visited
    private int timer;

    /*
    Tarjan's bridge-finding algorithm: a single DFS tracking two values per node.
      inTime[u]  - the time at which u was first discovered
      lowTime[u] - the earliest discovery time reachable from u's DFS subtree using
                   tree edges plus at most one back edge
    An edge (u -> v) where v is a DFS child of u is a bridge iff lowTime[v] > inTime[u],
    i.e. v's subtree has no way back to u or any of u's ancestors except through this edge.

    Why lowTime[v] > inTime[u] means bridge:
      Everything in v's subtree was discovered after u, so its inTime values are > inTime[u].
      The only way to escape to u or above without the edge u -> v is a back edge, which would
      pull lowTime[v] down to inTime[u] or lower.
        lowTime[v] <= inTime[u] -> subtree has a second route to u or above -> NOT a bridge
        lowTime[v] >  inTime[u] -> subtree can only reach itself -> u -> v is a bridge
      (The check is strict: lowTime[v] == inTime[u] means the subtree loops back to u itself,
      which is still a second path.)
      The parent is skipped in the DFS because the edge back to it is the very edge we came down.

    Example: edges 0-1, 1-2, 2-3, 3-1. DFS order 0 -> 1 -> 2 -> 3, so inTime = [0, 1, 2, 3].
      3 sees back edge to 1 -> lowTime[3] = 1, and lowTime[2] = 1 (inherited from 3)
      edge 2 -> 3: lowTime[3]=1 > inTime[2]=2 ? no  -> not a bridge (3 loops back to 1)
      edge 1 -> 2: lowTime[2]=1 > inTime[1]=1 ? no  -> not a bridge (cycle 1-2-3 passes through 1)
      edge 0 -> 1: lowTime[1]=1 > inTime[0]=0 ? yes -> bridge [0, 1]

    Time: O(V + E), Space: O(V + E)
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        List<List<Integer>> adjList = buildAdjacencyList(n, connections);

        int[] inTime = new int[n];
        int[] lowTime = new int[n];
        // -1 marks "not visited yet", so no separate visited array is needed
        Arrays.fill(inTime, -1);
        timer = 0;

        // The graph is guaranteed connected, so one DFS from node 0 covers every node
        dfs(0, -1, adjList, inTime, lowTime, bridges);

        return bridges;
    }

    private void dfs(int node, int parent, List<List<Integer>> adjList, int[] inTime, int[] lowTime, List<List<Integer>> bridges) {
        inTime[node] = lowTime[node] = timer++;

        for (int neighbour : adjList.get(node)) {
            // Going back along the tree edge we came from says nothing about alternate paths
            if (neighbour == parent) {
                continue;
            }

            if (inTime[neighbour] != -1) {
                // Back edge to an already-visited node: node can reach it directly,
                // so node's low-link can drop to that node's discovery time
                lowTime[node] = Math.min(lowTime[node], inTime[neighbour]);
            } else {
                // Tree edge: explore the child, then inherit whatever it can reach
                dfs(neighbour, node, adjList, inTime, lowTime, bridges);
                lowTime[node] = Math.min(lowTime[node], lowTime[neighbour]);

                // Child's subtree cannot reach node or above without this edge -> bridge
                if (lowTime[neighbour] > inTime[node]) {
                    bridges.add(List.of(node, neighbour));
                }
            }
        }
    }

    private List<List<Integer>> buildAdjacencyList(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> connection : connections) {
            adjList.get(connection.get(0)).add(connection.get(1));
            adjList.get(connection.get(1)).add(connection.get(0));
        }

        return adjList;
    }
}
