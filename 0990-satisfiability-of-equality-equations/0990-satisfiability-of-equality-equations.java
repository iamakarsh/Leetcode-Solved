class Solution {
    static int[] parent = new int[26];
    static int[] rank = new int[26];
    static int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int a,int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return;
        if(rank[pa] < rank[pb]){
            parent[pa] = pb;
        }
        else if(rank[pb] < rank[pa]){
            parent[pb] = pa;
        }
        else{
            parent[pb] = pa;
            rank[pa]++;
        }
    }
    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<26;i++){
            parent[i] = i;
        }
        // ==
        for(String eq : equations){
            if(eq.charAt(1) == '='){
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';
                union(a,b);
            }
        }
        //  !=
        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';

                if(find(a) == find(b))
                    return false;
            }
        }
        return true;
    }
}