import java.util.*;

class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;

        // Step 1: build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {   // 1-indexed graph
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        // Step 2: find node with degree n-1
        for (int i = 1; i <= n; i++) {
            if (adj.get(i).size() == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
