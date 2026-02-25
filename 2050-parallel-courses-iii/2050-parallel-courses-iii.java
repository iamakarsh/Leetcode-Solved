class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1];
        for(int i = 0; i < relations.length; i++){
            int u = relations[i][0];
            int v = relations[i][1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = time[i - 1];  
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int u = q.poll();   
            for(int v : adj.get(u)){
                dp[v] = Math.max(dp[v], dp[u] + time[v - 1]);
                indegree[v]--;
                if(indegree[v] == 0){
                    q.add(v);
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}