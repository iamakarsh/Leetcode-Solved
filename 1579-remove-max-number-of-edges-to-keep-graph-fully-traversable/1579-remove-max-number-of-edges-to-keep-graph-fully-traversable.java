class Solution {
    static int[] parent;
    static int[] rank;
    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    static boolean union(int a,int b){
        int pa=find(a);
        int pb=find(b);
        if(pa==pb) return false;
        if(rank[pa]<rank[pb]){
            parent[pa]=pb;
        }else if(rank[pa]>rank[pb]){
            parent[pb]=pa;
        }else{
            parent[pb]=pa;
            rank[pa]++;
        }
        return true; 
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int remove=0;
        int[] parentAlice = new int[n+1];
        int[] rankAlice = new int[n+1];
        int[] parentBob = new int[n+1];
        int[] rankBob = new int[n+1];
        for(int i=1;i<=n;i++){
            parentAlice[i] = i;
            parentBob[i] = i;
        }
        int usedAlice = 0;
        int usedBob = 0;
        for(int[] e : edges){
            if(e[0] == 3){
                parent = parentAlice;
                rank = rankAlice;
                boolean a = union(e[1],e[2]);
                parent = parentBob;
                rank = rankBob;
                boolean b = union(e[1],e[2]);
                if(a){
                    usedAlice++;
                    usedBob++;
                }else{
                    remove++;
                }
            }
        }
        parent = parentAlice;
        rank = rankAlice;
        for(int[] e : edges){
            if(e[0] == 1){
                if(union(e[1],e[2])){
                    usedAlice++;
                }else{
                    remove++;
                }
            }
        }
        parent=parentBob;
        rank=rankBob;
        for(int[] e:edges){
            if(e[0]==2){
                if(union(e[1],e[2])){
                    usedBob++;
                }else{
                    remove++;
                }
            }
        }
        if(usedAlice!=n-1 || usedBob!=n-1) return -1;
        return remove;
    }
}