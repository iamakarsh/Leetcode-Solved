class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        // matrix se adj List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        // province count ke liye dfs
        boolean[] vis = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                provinces++;
            }
        }

        return provinces;
    }

    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis) {

        vis[node] = true;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int neigh = adj.get(node).get(i);

            if (!vis[neigh]) {
                dfs(neigh, adj, vis);
            }
        }
    }
}    
