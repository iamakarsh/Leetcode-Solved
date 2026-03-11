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
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        int mstWeight=0;
        int edgesUsed=0;
        List<int[]> edges=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{i,j,dist});
            }
        }
        Collections.sort(edges,(a,b)->a[2]-b[2]);
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            if(find(u)!=find(v)){
                union(u,v);
                mstWeight+=w;
                edgesUsed++;
                if(edgesUsed==n-1) break;
            }
        }
        return mstWeight;
    }
}