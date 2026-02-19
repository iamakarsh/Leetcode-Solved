class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int arr[]:prerequisites){
            int u=arr[0];
            int v=arr[1];
            adj.get(u).add(v);
            indegree[v]+=1;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            ans.add(curr);
            for(int i = 0; i < adj.get(curr).size(); i++){
                int x = adj.get(curr).get(i);
                indegree[x]-=1;
                if(indegree[x]==0){
                    q.add(x);
                }
            }
        }
        return (ans.size()==numCourses)?true:false;
    }
}