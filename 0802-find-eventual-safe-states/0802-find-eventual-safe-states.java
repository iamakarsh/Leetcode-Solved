class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        
        List<List<Integer>> rev = new ArrayList<>();
        for(int i = 0; i < n; i++)
            rev.add(new ArrayList<>());
        
        int[] indegree = new int[n];
        
        // Reverse
        for(int i = 0; i < n; i++) {
            for(int v : graph[i]) {
                rev.get(v).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        // Add nodes with indegree 0
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }
        
        List<Integer> safe = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int node = q.poll();
            safe.add(node);
            
            for(int i = 0; i < rev.get(node).size(); i++) {
                int nei = rev.get(node).get(i);
                indegree[nei]--;
                if(indegree[nei] == 0)
                    q.add(nei);
            }
        }
        
        Collections.sort(safe);
        return safe;
    }
}