class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        // DFS
        boolean[] vis = new boolean[n];
        return dfs(source, destination, adjList, vis);
    }

    public boolean dfs(int node, int destination,ArrayList<ArrayList<Integer>> adj,boolean[] vis) {

        if (node == destination) return true;

        vis[node] = true;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int neigh = adj.get(node).get(i);
            if (!vis[neigh]) {
                if (dfs(neigh, destination, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}
