//brute force in notes.
class Solution {
    static int[] parent;
    static int[] rank;

    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }

    static void union(int a,int b){
        int pa=find(a);
        int pb=find(b);
        if(pa==pb) return;

        if(rank[pa]<rank[pb]){
            parent[pa]=pb;
        }else if(rank[pa]>rank[pb]){
            parent[pb]=pa;
        }else{
            parent[pb]=pa;
            rank[pa]++;
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);

        int q=queries.length;
        int[][] q2=new int[q][4];

        for(int i=0;i<q;i++){
            q2[i][0]=queries[i][0];
            q2[i][1]=queries[i][1];
            q2[i][2]=queries[i][2];
            q2[i][3]=i;
        }

        Arrays.sort(q2,(a,b)->a[2]-b[2]);

        boolean[] ans=new boolean[q];
        int j=0;

        for(int i=0;i<q;i++){

            int u=q2[i][0];
            int v=q2[i][1];
            int limit=q2[i][2];
            int idx=q2[i][3];

            while(j<edgeList.length && edgeList[j][2]<limit){
                union(edgeList[j][0],edgeList[j][1]);
                j++;
            }

            ans[idx]=find(u)==find(v);
        }

        return ans;
    }
}