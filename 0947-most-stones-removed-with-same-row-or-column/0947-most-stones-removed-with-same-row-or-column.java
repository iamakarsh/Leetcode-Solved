class Solution {
    static int[] parent;
    static int[] rank;
    static int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }
    static void union(int a,int b){
    int pa = find(a);
    int pb = find(b);
    if(pa == pb) return;
    if(rank[pa] < rank[pb]){
        parent[pa] = pb;
    }
    else{
        if(rank[pa] == rank[pb]){
            rank[pa]++;
        }
        parent[pb] = pa;
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                //same row OR same column
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    union(i,j);
                }
            }
        }
        int components=0;
        for(int i=0;i<n;i++){
            if(find(i)==i){
                components++;
            }
        }
        return n-components;
    }
}